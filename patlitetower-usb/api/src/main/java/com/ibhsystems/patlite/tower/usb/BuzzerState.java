package com.ibhsystems.patlite.tower.usb;

import com.ibhsystems.patlite.tower.usb.lib.USB_PAT_Tower;

public enum BuzzerState {

	OFF(USB_PAT_Tower.OFF_STATIC), //
	ON(USB_PAT_Tower.ON_STATIC), //

	NORMAL(USB_PAT_Tower.PATT_MOVE1), //
	SLOW(USB_PAT_Tower.PATT_MOVE2), //
	DOUBLE(USB_PAT_Tower.PATT_MOVE3), //
	FAST(USB_PAT_Tower.PATT_MOVE4), //

	KEEP_EXISTING(USB_PAT_Tower.PATT_KEEP); //

	private byte state;

	BuzzerState(byte state) {
		this.state = state;
	}

	byte asByte() {
		return state;
	}

	static byte asByteSafe(BuzzerState state) {
		if (state == null) {
			return KEEP_EXISTING.asByte();
		}
		return state.asByte();
	}
}
