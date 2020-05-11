package com.ibhsystems.patlite.tower.usb;

import com.ibhsystems.patlite.tower.usb.lib.USB_PAT_Tower;

public enum ErrorCode {
	
	UNKNOWN(Integer.MIN_VALUE), //

	NOEXIST(USB_PAT_Tower.ERR_NOEXIST), //
	LOCKED(USB_PAT_Tower.ERR_LOCKED), //
	CONNECTION(USB_PAT_Tower.ERR_CONNECTION), //
	PARAM(USB_PAT_Tower.ERR_PARAM), //
	TRANSFAIL_EVNT(USB_PAT_Tower.ERR_TRANSFAIL_EVNT), //
	TRANSFAIL_TMOUT(USB_PAT_Tower.ERR_TRANSFAIL_TMOUT), //
	TRANSFAIL_SEND(USB_PAT_Tower.ERR_TRANSFAIL_SEND), //
	DLL_LINK(USB_PAT_Tower.ERR_DLL_LINK), //

	OK(0); //

	private int error;

	ErrorCode(int error) {
		this.error = error;
	}

	int getError() {
		return error;
	}

	static ErrorCode fromErrorCode(int error) {
		for (ErrorCode e : ErrorCode.values()) {
			if (e.getError() == error) {
				return e;
			}
		}
		return UNKNOWN;
	}
}
