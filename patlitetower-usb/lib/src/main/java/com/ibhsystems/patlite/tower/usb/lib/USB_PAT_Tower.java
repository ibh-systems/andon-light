package com.ibhsystems.patlite.tower.usb.lib;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface USB_PAT_Tower extends Library {

	USB_PAT_Tower INSTANCE = Native.load(
			"USB_PAT_Tower" + (System.getProperty("os.arch").contains("amd64") ? "x64" : ""), USB_PAT_Tower.class);
	
	/* Pattern of Lighting and Buzzer */
	byte OFF_STATIC = 0;
	byte ON_STATIC = 1;
	byte PATT_MOVE1 = 2;
	byte PATT_MOVE2 = 3;
	byte PATT_MOVE3 = 4;
	byte PATT_MOVE4 = 5;
	byte PATT_KEEP = 9;

	/* Color of LED Unit */
	byte UPT_RED = 10;
	byte UPT_YEL = 11;
	byte UPT_GRN = 12;
	byte UPT_BLU = 13;
	byte UPT_CLR = 14;

	/* Pitch of Buzzer */
	byte BUZ_PITCH_OFF = 20;
	byte BUZ_PITCH1 = 21;
	byte BUZ_PITCH2 = 22;
	byte BUZ_PITCH3 = 23;
	byte BUZ_PITCH4 = 24;
	byte BUZ_PITCH5 = 25;
	byte BUZ_PITCH6 = 26;
	byte BUZ_PITCH7 = 27;
	byte BUZ_PITCH8 = 28;
	byte BUZ_PITCH9 = 29;
	byte BUZ_PITCH10 = 30;
	byte BUZ_PITCH11 = 31;
	byte BUZ_PITCH12 = 32;
	byte BUZ_PITCH13 = 33;
	byte BUZ_PITCH_DFLT = 59;

	/* ERROR Value */
	int ERR_NOEXIST = -1;
	int ERR_LOCKED = -2;
	int ERR_CONNECTION = -3;
	int ERR_PARAM = -4;
	int ERR_TRANSFAIL_EVNT = -5;
	int ERR_TRANSFAIL_TMOUT = -6;
	int ERR_TRANSFAIL_SEND = -7;
	int ERR_DLL_LINK = -8;

	int UPT_GetDllVer();

	int UPT_GetFirmVer();

	int UPT_Open();

	void UPT_Close();

	int UPT_SetLight(byte color, byte led_state);

	int UPT_SetTower(byte red, byte yel, byte grn, byte blu, byte clr);

	int UPT_SetBuz(byte buz_state, byte limit);

	int UPT_SetBuzEx(byte buz_state, byte limit, byte pitch1, byte pitch2);

	int UPT_Reset();

}