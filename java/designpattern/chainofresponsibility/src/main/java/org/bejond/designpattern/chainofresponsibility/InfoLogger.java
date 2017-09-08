package org.bejond.designpattern.chainofresponsibility;

public class InfoLogger extends Logger {

	public InfoLogger() {

		setLogLevel(LogLevel.INFO);
		setNextLogger(new DebugLogger());
	}

	@Override
	public void write(String info) {

		System.out.println("INFO: " + info);
	}
}
