package com.bejond.wholetest;

import org.junit.Test;

/**
 * Created by Bejond on 2016/7/7.
 */
public class StringTest {

	@Test
	public void testLength() {

		String string = "你还好吗";
		String string2 = "hel你还好吧oo";
		System.out.println(string.length()); // 4
		System.out.println(string2.length()); // 9
		System.out.println(string.substring(2)); // 好吗
		System.out.println(string.substring(0, 2)); // 你还
	}
}
