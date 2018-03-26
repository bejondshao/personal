package org.bejond.wholetest;

import org.junit.Test;

public class StringBufferTest {

	@Test
	public void testStringBuffer() {
		StringBuffer a = new StringBuffer("A");
		StringBuffer b = new StringBuffer("B");
		operator(a, b);
		System.out.println(a + ", " + b); // AB, B
	}

	public void operator(StringBuffer x, StringBuffer y) {

		x.append(y);
		y = x;
	}
}
