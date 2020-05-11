package com.ibhsystems.patlite.tower.usb;

import java.io.IOException;
import java.util.List;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class PatliteTowerCli {

	public static void main(String[] args) throws IOException, InterruptedException {
		final PatliteTowerArguments arguments = new PatliteTowerArguments();
		CmdLineParser parser = new CmdLineParser(arguments);
		try {
			parser.parseArgument(args);
		} catch (CmdLineException e) {
			System.err.println(e.getMessage());
			System.err.println("java -jar patlitetower-usb-full.jar [options...]");
			parser.printUsage(System.err);
			System.exit(1);
		}

		if (arguments.printVersion) {
			System.out.println(PatliteTower.getVersion());
			System.exit(0);
		}

		if (arguments.printDllVersion) {
			try {
				System.out.println(PatliteTower.getDllVersion());
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(2);
			}
			System.exit(0);
		}

		if (arguments.printFirmwareVersion) {
			Version version = withPatliteTower(new Function<Version>() {
				@Override
				public Version apply(PatliteTower pt) throws IOException {
					return pt.getFirmwareVersion();
				}
			});
			System.out.println(version);
			System.exit(0);
		}

		if (arguments.reset) {
			withPatliteTower(new Call() {
				@Override
				public void apply(PatliteTower pt) throws IOException {
					pt.reset();
				}
			});
			System.exit(0);
		}

		boolean handled = false;
		if (arguments.setLight) {
			withPatliteTower(new Call() {
				@Override
				public void apply(PatliteTower pt) throws IOException {
					pt.setLight(arguments.color, arguments.state);
				}
			});
			handled = true;
		} else if (arguments.tower != null && !arguments.tower.isEmpty()) {
			withPatliteTower(new Call() {
				@Override
				public void apply(PatliteTower pt) throws IOException {
					pt.setTower( //
							valueAtOrNull(arguments.tower, 0), //
							valueAtOrNull(arguments.tower, 1), //
							valueAtOrNull(arguments.tower, 2), //
							valueAtOrNull(arguments.tower, 3), //
							valueAtOrNull(arguments.tower, 4) //
					);
				}
			});
			handled = true;
		}

		if (arguments.buzzerState != null && arguments.buzzerPitch1 == null && arguments.buzzerPitch2 == null) {
			withPatliteTower(new Call() {
				@Override
				public void apply(PatliteTower pt) throws IOException {
					pt.setBuzzer(arguments.buzzerState, arguments.buzzerLimit);
				}
			});
			handled = true;
		} else if (arguments.buzzerState != null && arguments.buzzerPitch1 != null && arguments.buzzerPitch2 != null) {
			withPatliteTower(new Call() {
				@Override
				public void apply(PatliteTower pt) throws IOException {
					pt.setBuzzer(arguments.buzzerState, arguments.buzzerLimit, arguments.buzzerPitch1,
							arguments.buzzerPitch2);
				}
			});
			handled = true;
		}

		if (!handled) {
			parser.printUsage(System.err);
			System.exit(1);
		}

		System.exit(0);
	}

	static <R> R withPatliteTower(final Function<R> func) {
		try {
			PatliteTower pt = null;
			try {
				pt = new PatliteTower();
				return func.apply(pt);
			} finally {
				if (pt != null) {
					pt.close();
				}
			}
		} catch (PatliteTowerException e) {
			System.err.println("PatliteTower return error: " + e.getErrorCode());
			e.printStackTrace();
			System.exit(e.getUnderlyingErrorCode());
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(3);
		}
		return null;
	}

	static void withPatliteTower(final Call call) {
		withPatliteTower(new Function<Void>() {
			@Override
			public Void apply(PatliteTower pt) throws IOException {
				call.apply(pt);
				return null;
			}
		});
	}

	static interface Function<R> {
		R apply(PatliteTower pt) throws IOException;
	}

	static interface Call {
		void apply(PatliteTower pt) throws IOException;
	}

	static <T> T valueAtOrNull(List<T> list, int index) {
		if (index >= list.size()) {
			return null;
		}
		return list.get(index);
	}

}