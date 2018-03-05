package org.bejond.wholetest.stackoverflow;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GregorianCalendarTest {

	@Test
	public void testGregorianCalendar() {
		GregorianCalendar fromCalendar = new GregorianCalendar(2017, 8, 21, 23, 58);

		for (int i = 0; i < 10; i++) {
			System.out.println(fromCalendar.get(Calendar.YEAR) + "-"
							+ (fromCalendar.get(Calendar.MONTH) + 1) + "-" +   fromCalendar.get(Calendar.DAY_OF_MONTH) + " "
							+ fromCalendar.get(Calendar.HOUR_OF_DAY) + ":" + fromCalendar.get(Calendar.MINUTE) + "      ");
			fromCalendar.add(Calendar.MINUTE, 1);
		}
	}
}
