package org.bejond.designpattern.chainofresponsibility;

public class SimpleLogger extends Logger {

	public SimpleLogger() {

		setLogLevel(LogLevel.SIMPLE);
		setNextLogger(new ErrorLogger());
	}

	@Override
	public void write(String info) {

		System.out.println("Simple: " + info);
	}
}
