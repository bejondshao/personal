package com.bejond.wholetest;

import org.junit.Test;

/**
 * Created by bejond on 16-4-1.
 */

public class TestCase {
public static String toLowerCase(String s) {
		if (s == null) {
			return null;
		}

		StringBuilder sb = null;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);



			if ((c >= 'A') && (c <= 'Z')) {
				if (sb == null) {
					sb = new StringBuilder(s);
				}

				sb.setCharAt(i, (char)(c + 32));
			}
		}

		if (sb == null) {
			return s;
		}

		return sb.toString();
	}

	@Test
	public void test1() {
		String str = "C_t";
		str = TestCase.toLowerCase(str);
		System.out.println(str);
	}

	@Test
	public void test2() {
		String str = "c_TT";
		str = TestCase.toLowerCase(str);
		System.out.println(str);
	}

	@Test
	public void testCompareTo() {
		String a = "aeb";
		String c = "dde";
		String d = "D";

		System.out.println(a.compareTo(c)); // the result is -3, it means it only compare the first character in the string.
		System.out.println(a.compareTo(d));
		System.out.println(a.compareToIgnoreCase(d));
	}

	@Test
	public void test1() {
		int j = 1;
		for (int i = 0; i < 5; i++) {
			j = j++;
		}
		System.out.print(j);
		// The out put is 1. As j++ returns j, which is 1. So j = j, j is 1 at last.
	}
}

