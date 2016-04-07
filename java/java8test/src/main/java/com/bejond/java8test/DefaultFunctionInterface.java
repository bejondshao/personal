package com.bejond.java8test;

/**
 * Created by bejond on 16-4-7.
 */
public interface DefaultFunctionInterface {
	default int count() {
		return 10;
	}

	static String findName() {
		return "Good";
	}
}
