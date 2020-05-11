package com.ibhsystems.patlite.tower.usb;

import java.io.Closeable;
import java.io.IOException;

import com.ibhsystems.patlite.tower.usb.lib.USB_PAT_Tower;

public class PatliteTower implements Closeable {

	private boolean closed = false;

	public PatliteTower() throws IOException {
		checkError(USB_PAT_Tower.INSTANCE.UPT_Open());
	}

	public void close() throws IOException {
		if (closed) {
			return;
		}
		USB_PAT_Tower.INSTANCE.UPT_Close();
	}

	public Version getFirmwareVersion() {
		checkIfClosed();
		return new Version(USB_PAT_Tower.INSTANCE.UPT_GetFirmVer());
	}

	public void reset() throws IOException {
		checkIfClosed();
		checkError(USB_PAT_Tower.INSTANCE.UPT_Reset());
	}

	public void setLight(LEDColor color, LEDState state) throws IOException {
		if (color == null) {
			throw new IllegalArgumentException("'color' must not be null");
		}
		checkIfClosed();
		checkError(USB_PAT_Tower.INSTANCE.UPT_SetLight(color.asByte(), LEDState.asByteSafe(state)));
	}

	public void setTower(LEDState red, LEDState amber, LEDState green, LEDState blue, LEDState clear)
			throws IOException {
		checkIfClosed();
		checkError(USB_PAT_Tower.INSTANCE.UPT_SetTower(//
				LEDState.asByteSafe(red), //
				LEDState.asByteSafe(amber), //
				LEDState.asByteSafe(green), //
				LEDState.asByteSafe(blue), //
				LEDState.asByteSafe(clear)) //
		);
	}

	public void setBuzzer(BuzzerState state, boolean limit) throws IOException {
		checkIfClosed();
		checkError(USB_PAT_Tower.INSTANCE.UPT_SetBuz(BuzzerState.asByteSafe(state), (byte) (limit ? 1 : 0)));
	}

	public void setBuzzer(BuzzerState state, boolean limit, BuzzerPitch pitch1, BuzzerPitch pitch2) throws IOException {
		checkIfClosed();
		checkError(USB_PAT_Tower.INSTANCE.UPT_SetBuzEx(BuzzerState.asByteSafe(state), (byte) (limit ? 1 : 0),
				BuzzerPitch.asByteSafe(pitch1), BuzzerPitch.asByteSafe(pitch2)));
	}

	private void checkIfClosed() {
		if (closed) {
			throw new IllegalStateException("Instance already closed!");
		}
	}

	private void checkError(int code) throws IOException {
		final ErrorCode errorCode = ErrorCode.fromErrorCode(code);
		if (errorCode != ErrorCode.OK) {
			this.close();
			throw new PatliteTowerException(errorCode, code, "");
		}
	}

	public static Version getDllVersion() {
		return new Version(USB_PAT_Tower.INSTANCE.UPT_GetDllVer());
	}

}
