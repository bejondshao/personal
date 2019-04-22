package org.bejond.wholetest;

import org.apache.commons.lang3.StringUtils;
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

	@Test
	public void testConcat() {

		String a = null;
		String b = null;
		String c = a + b;
		System.out.println("c = " + c); // Output: c = nullnull
		a = a == null ? "" : a;
		b = b == null ? "" : b;
		String d = a + b;
		System.out.println("d = " + d); // Output: d =
	}

	public boolean isBothBlank(String lastName, String firstName) {

		return StringUtils.isBlank(lastName) && StringUtils.isBlank(firstName);
	}

	@Test
	public void testStringBuffer() {

		String lastName = "asdf";
		String firstName = null;
		String name = null;
		StringBuffer name1 = new StringBuffer(lastName);

		name = name1.append(firstName).toString();

		System.out.println(name);
	}

	/**
	 * test exception before assigning
	 */
	@Test
	public void testException() {
		int a = 2;
		String b = null;
		try {
			a = b.length();
		} catch ( Exception e ) {}

		System.out.print(a);

	}

	/**
	 * test equals(null)
	 */
	@Test
	public void testEqualsNull() {
		String a = "a";
		String b = null;
		System.out.println(a.equals(b)); // false
	}

	/**
	 * test a + null
	 */
	@Test
	public void testStringAppendNull() {
		String a = "a";
		String b = null;
		System.out.println(a + b); // anull
		String c = "c";
		c += a;
		System.out.println(c);
	}

	/**
	 * Test StringBuilder a + null
	 */
	@Test
	public void testStringBuilderAppendNull() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("a");
		String b = null;
		stringBuilder.append(b);
		System.out.println(stringBuilder.toString()); // anull
		System.out.println(new StringBuilder("a").append(b).toString()); // anull
	}
}
