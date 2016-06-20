package com.bejond.wholetest;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by bejond on 2016/6/15.
 */
public class DateTest {

	@Test
	public void testDateString() {

		LocalDateTime localDateTime = LocalDateTime.now();

		System.out.println(localDateTime);

		String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

		System.out.println(time);
		System.out.println(time.substring(0,8));
		System.out.println(time.substring(8));
	}
}
