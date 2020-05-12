package com.ibhsystems.patlite.tower.usb.test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import com.ibhsystems.patlite.tower.usb.LEDColor;

public class LEDColorTest {

	@Test
	public void testColorConversion() {
		assertEquals(LEDColor.RED, LEDColor.fromColor(Color.RED));
		assertEquals(LEDColor.AMBER, LEDColor.fromColor(Color.ORANGE));
		assertEquals(LEDColor.GREEN, LEDColor.fromColor(Color.GREEN));
		assertEquals(LEDColor.BLUE, LEDColor.fromColor(Color.BLUE));
		assertEquals(LEDColor.CLEAR, LEDColor.fromColor(Color.WHITE));

		assertEquals(LEDColor.RED, LEDColor.fromColor(new Color(200, 0, 0)));
		assertEquals(LEDColor.AMBER, LEDColor.fromColor(Color.YELLOW));
		assertEquals(LEDColor.GREEN, LEDColor.fromColor(new Color(0, 200, 0)));
		assertEquals(LEDColor.BLUE, LEDColor.fromColor(new Color(0, 0, 200)));
		assertEquals(LEDColor.CLEAR, LEDColor.fromColor(Color.LIGHT_GRAY));
	}
}
