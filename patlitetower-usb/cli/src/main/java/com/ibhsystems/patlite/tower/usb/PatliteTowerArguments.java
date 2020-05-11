package com.ibhsystems.patlite.tower.usb;

import java.util.List;

import org.kohsuke.args4j.Option;

class PatliteTowerArguments {

	@Option(name = "-v", //
			aliases = { "--version" }, //
			forbids = { "-d", "-f", "-r", "-l", "-t", "-b" }, //
			usage = "prints version of this software")
	boolean printVersion = false;

	@Option(name = "-d", //
			aliases = { "--dll-version" }, //
			forbids = { "-v", "-f", "-r", "-l", "-t", "-b" }, //
			usage = "prints version of the underlying patlite tower dll")
	boolean printDllVersion = false;

	@Option(name = "-f", //
			aliases = { "--firmware-version" }, //
			forbids = { "-v", "-d", "-r", "-l", "-t", "-b" }, //
			usage = "prints firmware version of the connected patlite tower")
	boolean printFirmwareVersion = false;

	@Option(name = "-r", //
			aliases = { "--reset" }, //
			forbids = { "-v", "-d", "-f", "-l", "-t", "-b" }, //
			usage = "reset patlite tower")
	boolean reset = false;

	@Option(name = "-l", //
			aliases = { "--set-light" }, //
			forbids = { "-v", "-d", "-f", "-r", "-t" }, //
			usage = "set a single light of patlite tower")
	boolean setLight = false;

	@Option(name = "-c", //
			aliases = { "--color" }, //
			usage = "specify color to set", //
			depends = { "-l" })
	LEDColor color = null;

	@Option(name = "-s", //
			aliases = { "--state" }, //
			usage = "specify state for color to set", //
			depends = { "-l" })
	LEDState state = null;

	@Option(name = "-t", aliases = { "--tower" }, //
			forbids = { "-v", "-d", "-f", "-l", "-r" }, //
			usage = "set all lights of patlite tower", handler = LEDStateOptionsHandler.class)
	List<LEDState> tower = null;

	@Option(name = "-b", //
			aliases = { "--buzzer" }, //
			forbids = { "-v", "-d", "-f", "-r" }, //
			usage = "specify state for buzzer to set")
	BuzzerState buzzerState = null;

	@Option(name = "-m", //
			aliases = { "--limit" }, //
			depends = { "-b" }, //
			usage = "limit sound of buzzer")
	boolean buzzerLimit = false;

	@Option(name = "-p1", //
			aliases = { "--pitch1" }, //
			depends = { "-b", "-p2" }, //
			usage = "set pitch 1 of buzzer")
	BuzzerPitch buzzerPitch1 = null;

	@Option(name = "-p2", //
			aliases = { "--pitch2" }, //
			depends = { "-b", "-p1" }, //
			usage = "set pitch 2 of buzzer")
	BuzzerPitch buzzerPitch2 = null;
}
