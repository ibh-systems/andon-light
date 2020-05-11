package com.ibhsystems.patlite.tower.usb;

import java.io.IOException;

public class PatliteTowerException extends IOException {

	private static final long serialVersionUID = 1L;

	private final ErrorCode errorCode;

	private final int code;

	PatliteTowerException(ErrorCode errorCode, int code, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
		this.code = code;
	}

	PatliteTowerException(ErrorCode errorCode, int code, String message) {
		super(message);
		this.errorCode = errorCode;
		this.code = code;
	}

	PatliteTowerException(ErrorCode errorCode, int code, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
		this.code = code;
	}

	PatliteTowerException(int code, String message, Throwable cause) {
		this(ErrorCode.fromErrorCode(code), code, message, cause);
	}

	PatliteTowerException(int code, String message) {
		this(ErrorCode.fromErrorCode(code), code, message);
	}

	PatliteTowerException(int code, Throwable cause) {
		this(ErrorCode.fromErrorCode(code), code, cause);
	}

	ErrorCode getErrorCode() {
		return errorCode;
	}

	int getUnderlyingErrorCode() {
		return code;
	}
}
