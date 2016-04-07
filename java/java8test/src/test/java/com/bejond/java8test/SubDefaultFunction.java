package com.bejond.java8test;

import org.junit.Test;

/**
 * Created by bejond on 16-4-7.
 */

public class SubDefaultFunction implements DefaultFunctionInterface {
	@Test
	public void testDefaultFunction() {
		SubDefaultFunction subDefaultFunction = new SubDefaultFunction();
		System.out.println(subDefaultFunction.count());
	}

	@Test
	public void testStaticFunction() {
		String name = DefaultFunctionInterface.findName(); // subclass can't inherit parent static method
		System.out.println(name.replace('o', 'u'));
	}
}
