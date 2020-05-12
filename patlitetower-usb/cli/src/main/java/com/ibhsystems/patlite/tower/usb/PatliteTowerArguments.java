package com.ibhsystems.patlite.tower.usb;

import java.util.List;

import org.kohsuke.args4j.Option;

class PatliteTowerArguments {

	@Option(name = "-v", //
			aliases = { "--version" }, //
			forbids = { "-d", "-f", "-r", "-s", "-a", "-b" }, //
			usage = "prints version of this software")
	boolean printVersion = false;

	@Option(name = "-d", //
			aliases = { "--dll-version" }, //
			forbids = { "-v", "-f", "-r", "-s", "-a", "-b" }, //
			usage = "prints version of the underlying patlite tower dll")
	boolean printDllVersion = false;

	@Option(name = "-f", //
			aliases = { "--firmware-version" }, //
			forbids = { "-v", "-d", "-r", "-s", "-a", "-b" }, //
			usage = "prints firmware version of the connected patlite tower")
	boolean printFirmwareVersion = false;

	@Option(name = "-r", //
			aliases = { "--reset" }, //
			forbids = { "-v", "-d", "-f", "-s", "-a", "-b" }, //
			usage = "reset patlite tower")
	boolean reset = false;

	@Option(name = "-s", //
			aliases = { "--light", "--set-light", "--single" }, //
			forbids = { "-v", "-d", "-f", "-r", "-a" }, //
			usage = "set a single light")
	LEDState singleLightState = null;

	@Option(name = "-c", //
			aliases = { "--color" }, //
			usage = "specify color to set", //
			depends = { "-s" })
	LEDColor color = null;

	@Option(name = "-a", aliases = { "--all" }, //
			forbids = { "-v", "-d", "-f", "-s", "-r" }, //
			usage = "set all lights at once. ", handler = LEDStateOptionsHandler.class)
	List<LEDState> allLights = null;

	@Option(name = "-b", //
			aliases = { "--buzzer" }, //
			forbids = { "-v", "-d", "-f", "-r" }, //
			usage = "specify state for buzzer to set")
	BuzzerState buzzerState = null;

	@Option(name = "-l", //
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
