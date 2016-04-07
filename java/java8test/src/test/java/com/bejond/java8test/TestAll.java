package com.bejond.java8test;

import org.junit.Test;

/**
 * Created by bejond on 16-4-7.
 */

public class TestAll {
	public static FooFuncInterface fooFuncInterface;

	static {
		fooFuncInterface = new FooFuncInterface();
	}

	@Test
	public void testFooFuncInterfaceBeforeJava8() {
		String test = "asdf";

		fooFuncInterface.fooIt(
			new FuncInterface() {
				@Override
				public String foo(String string) {
					return string.toUpperCase();
				}
			},
			test);
	}

	@Test
	public void testFooFuncInterface() {
		String test = "HelLo";

		fooFuncInterface.fooIt(
			(String string) -> {
				string = string.toLowerCase();
				return string;
			},
			test);
	}
}
