package org.bejond.wholetest;

import org.junit.Test;

public class ClassB {
	static int j = 20;

	@Test
	public void testA() {
		System.out.println(ClassB.j);
		System.out.println(ClassA.k);
	}

	public static void main(String[] args) {
		System.out.println(ClassB.j);
		System.out.println(ClassA.k);
	}
}
