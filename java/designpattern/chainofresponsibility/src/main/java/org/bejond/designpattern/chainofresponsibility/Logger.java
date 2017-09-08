package org.bejond.designpattern.chainofresponsibility;

public abstract class Logger {

	private LogLevel logLevel;

	private Logger nextLogger;

	public LogLevel getLogLevel() {

		return logLevel;
	}

	public void setLogLevel(LogLevel logLevel) {

		this.logLevel = logLevel;
	}

	public Logger getNextLogger() {

		return nextLogger;
	}

	public void setNextLogger(Logger nextLogger) {

		this.nextLogger = nextLogger;
	}

	public void log(LogLevel logLevel, String info) {

		write(info);

		if (this.logLevel.getLevel() < logLevel.getLevel()) {
			nextLogger.log(logLevel, info);
		}
	}

	public abstract void write(String info);
}
