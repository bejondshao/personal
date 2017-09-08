package org.bejond.designpattern.chainofresponsibility;

public class ErrorLogger extends Logger {

	public ErrorLogger() {

		setLogLevel(LogLevel.ERROR);
		setNextLogger(new InfoLogger());
	}

	@Override
	public void write(String info) {

		System.out.println("ERROR: " + info);
	}
}
