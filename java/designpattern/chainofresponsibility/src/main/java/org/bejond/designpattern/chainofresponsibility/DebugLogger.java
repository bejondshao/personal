package org.bejond.designpattern.chainofresponsibility;

public class DebugLogger extends Logger {

	public DebugLogger() {

		setLogLevel(LogLevel.DEBUG);
		setNextLogger(null);
	}

	@Override
	public void write(String info) {

		System.out.println("DEBUG: " + info);
	}
}
