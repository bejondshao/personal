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
}

