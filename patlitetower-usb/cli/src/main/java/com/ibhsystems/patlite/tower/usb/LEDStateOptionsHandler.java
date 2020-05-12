package com.ibhsystems.patlite.tower.usb;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionDef;
import org.kohsuke.args4j.spi.OptionHandler;
import org.kohsuke.args4j.spi.Parameters;
import org.kohsuke.args4j.spi.Setter;

public class LEDStateOptionsHandler extends OptionHandler<LEDState> {

	public LEDStateOptionsHandler(CmdLineParser parser, OptionDef option, Setter<LEDState> setter) {
		super(parser, option, setter);
	}

	@Override
	public String getDefaultMetaVariable() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (LEDState t : LEDState.values()) {
			sb.append(t).append(" | ");
		}
		sb.delete(sb.length() - 3, sb.length());
		sb.append("]");
		return "RED AMBER GREEN BLUE CLEAR (each of " + sb + ")";
	}

	@Override
	public int parseArguments(Parameters params) throws CmdLineException {
		int counter = 0;
		for (; counter < params.size(); counter++) {
			String param = params.getParameter(counter);

			if (param.startsWith("-")) {
				break;
			}

			for (String p : param.split(" ")) {
				setter.addValue(LEDState.valueOf(p));
			}
		}

		return counter;
	}
}
