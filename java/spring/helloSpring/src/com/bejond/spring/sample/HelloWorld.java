package com.bejond.spring.sample;

/**
 * Created by bejond on 15-9-16.
 */
public class HelloWorld {
	private String _message;

	public void setMessage(String message) {
		_message = message;
	}

	public void getMessage() {
		System.out.println("Your message is: " + _message);
	}

	public void init() {
		System.out.println("Your bean is initializing.");
	}

	public void destory() {
		System.out.println("Your bean is destroying");
	}
}
