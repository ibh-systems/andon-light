package com.ibhsystems.patlite.tower.usb;

import com.ibhsystems.patlite.tower.usb.lib.USB_PAT_Tower;

public enum LEDState {

	OFF(USB_PAT_Tower.OFF_STATIC), //
	ON(USB_PAT_Tower.ON_STATIC), //
	BLINKING(USB_PAT_Tower.PATT_MOVE1), //
	SLOW_BLINKING(USB_PAT_Tower.PATT_MOVE2), //
	DOUBLE_FLASH(USB_PAT_Tower.PATT_MOVE3), //
	FLASH(USB_PAT_Tower.PATT_MOVE4), //
	KEEP_EXISTING(USB_PAT_Tower.PATT_KEEP); //

	private byte state;

	LEDState(byte state) {
		this.state = state;
	}

	byte asByte() {
		return state;
	}

	static byte asByteSafe(LEDState state) {
		if (state == null) {
			return KEEP_EXISTING.asByte();
		}
		return state.asByte();
	}
}
