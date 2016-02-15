package com.bejond.aop;

/**
 * Created by bejond on 16-2-15.
 */
public class LogInterceptor {
	public void beforeMethod() {
		System.out.println("doing things before method");
	}

	public void afterMethod() {
		System.out.println("doing things after method");
	}
}
