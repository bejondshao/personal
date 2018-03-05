package org.bejond.wholetest;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * Created by Bejond on 2016/7/7.
 */
public class StringTest {

	private interface I {

	}

	private interface I0 extends I {
		int interface0(int a, int b);
	}

	private interface I1 extends I {
		int interface1(double d);
	}

	@Test
	public void testSpilt() {

		String str = "1,2,3,4,";
		String[] strings = str.split(",");
		System.out.println(strings.length); // 4, not 5
	}

	@Test
	public void testLength() {

		String string = "你还好吗";
		String string2 = "hel你还好吧oo";
		System.out.println(string.length()); // 4
		System.out.println(string2.length()); // 9
		System.out.println(string.substring(2)); // 好吗
		System.out.println(string.substring(0, 2)); // 你还
	}

	@Test
	public void testReplace() {
		String str = "=\"String \"";
		str = str.replace('"', ' ');
		str = str.replace('=', ' ').trim();
		System.out.println(str);
	}

	@Test
	public void parseString() {

		String value = "";
		Integer integer = Integer.valueOf(value);
		System.out.print(integer);
	}
}
