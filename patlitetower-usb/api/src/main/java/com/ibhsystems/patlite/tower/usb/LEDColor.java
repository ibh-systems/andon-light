package com.ibhsystems.patlite.tower.usb;

import java.awt.Color;

import com.ibhsystems.patlite.tower.usb.lib.USB_PAT_Tower;

public enum LEDColor {

	Undefined((byte) 0, Color.BLACK), //

	Red(USB_PAT_Tower.UPT_RED, Color.RED), //
	Amber(USB_PAT_Tower.UPT_YEL, Color.ORANGE), //
	Green(USB_PAT_Tower.UPT_GRN, Color.GREEN), //
	Blue(USB_PAT_Tower.UPT_BLU, Color.BLUE), //
	White(USB_PAT_Tower.UPT_CLR, Color.WHITE);

	private byte color;

	private Color colorValue;

	LEDColor(byte color, Color colorValue) {
		this.color = color;
		this.colorValue = colorValue;
	}

	byte asByte() {
		return this.color;
	}

	public Color asColor() {
		return this.colorValue;
	}

	public static LEDColor fromColor(Color color) {
		if (color == null) {
			return Undefined;
		}
		if (color.equals(Color.BLACK)) {
			return Undefined;
		}
		Color closestColor = null;
		for (LEDColor ledColor : LEDColor.values()) {
			if (ledColor == Undefined) {
				continue;
			}
			if (closestColor == null) {
				closestColor = ledColor.asColor();
				continue;
			}
			double dist = calculateDistance(color, ledColor.asColor());
			double distClosest = calculateDistance(closestColor, ledColor.asColor());
			if (dist < distClosest) {
				closestColor = ledColor.asColor();
			}
		}
		return fromExactColor(closestColor);
	}

	static double calculateDistance(Color color1, Color color2) {
		return Math.sqrt(
				Math.pow(color2.getRed() - color1.getRed(), 2) + Math.pow(color2.getGreen() - color1.getGreen(), 2)
						+ Math.pow(color2.getBlue() - color1.getBlue(), 2));
	}

	private static LEDColor fromExactColor(Color color) {
		for (LEDColor ledColor : LEDColor.values()) {
			if (ledColor.asColor().equals(color)) {
				return ledColor;
			}
		}
		return Undefined;
	}
}
