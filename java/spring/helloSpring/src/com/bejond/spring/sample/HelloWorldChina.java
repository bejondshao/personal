package com.bejond.spring.sample;

/**
 * Created by bejond on 15-9-29.
 */
public class HelloWorldChina {
	private String _message;
	private String _address;

	public String getMessage() {
		System.out.println("The message is: " + _message);
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public String getAddress() {
		System.out.println("The address is: " + _address);
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}
}
