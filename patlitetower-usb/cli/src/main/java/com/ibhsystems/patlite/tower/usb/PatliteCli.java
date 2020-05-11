package com.ibhsystems.patlite.tower.usb;

import java.io.IOException;

public class PatliteCli {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println(PatliteTower.getDllVersion());
		PatliteTower tower = new PatliteTower();
		System.out.println(tower.getFirmwareVersion());
		tower.setTower(LEDState.BLINKING, LEDState.ON, LEDState.DOUBLE_FLASH, LEDState.OFF, LEDState.OFF);
		Thread.sleep(5000);
		tower.reset();
		tower.close();
	}
}
