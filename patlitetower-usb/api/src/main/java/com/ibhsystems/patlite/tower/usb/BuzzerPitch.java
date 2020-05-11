package com.ibhsystems.patlite.tower.usb;

import com.ibhsystems.patlite.tower.usb.lib.USB_PAT_Tower;

public enum BuzzerPitch {

	OFF(USB_PAT_Tower.BUZ_PITCH_OFF), //
	DEFAULT(USB_PAT_Tower.BUZ_PITCH_DFLT), //

	PITCH1(USB_PAT_Tower.BUZ_PITCH1), //
	PITCH2(USB_PAT_Tower.BUZ_PITCH2), //
	PITCH3(USB_PAT_Tower.BUZ_PITCH3), //
	PITCH4(USB_PAT_Tower.BUZ_PITCH4), //
	PITCH5(USB_PAT_Tower.BUZ_PITCH5), //
	PITCH6(USB_PAT_Tower.BUZ_PITCH6), //
	PITCH7(USB_PAT_Tower.BUZ_PITCH7), //
	PITCH8(USB_PAT_Tower.BUZ_PITCH8), //
	PITCH9(USB_PAT_Tower.BUZ_PITCH9), //
	PITCH10(USB_PAT_Tower.BUZ_PITCH10), //
	PITCH11(USB_PAT_Tower.BUZ_PITCH11), //
	PITCH12(USB_PAT_Tower.BUZ_PITCH12), //
	PITCH13(USB_PAT_Tower.BUZ_PITCH13); //

	private byte pitch;

	BuzzerPitch(byte pitch) {
		this.pitch = pitch;
	}

	byte asByte() {
		return pitch;
	}

	static byte asByteSafe(BuzzerPitch state) {
		if (state == null) {
			return DEFAULT.asByte();
		}
		return state.asByte();
	}
}
