package org.bejond.wholetest;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by bejond on 2016/6/15.
 */
public class DateTest {

	@Test
	public void testDateTime() {

		LocalDateTime localDateTime = LocalDateTime.now();

		System.out.println(localDateTime);

		String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

		System.out.println(time);
		System.out.println(time.substring(0,8));
		System.out.println(time.substring(8));
	}

	@Test
	public void testDate() {

		LocalDate localDate = LocalDate.now();
		String localDateString = localDate.toString();

		System.out.println(localDateString);
	}
}
