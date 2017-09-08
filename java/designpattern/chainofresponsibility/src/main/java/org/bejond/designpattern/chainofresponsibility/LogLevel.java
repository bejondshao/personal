package org.bejond.designpattern.chainofresponsibility;

public enum LogLevel {

	SIMPLE(0),
	ERROR(1),
	INFO(2),
	DEBUG(3);

	private int level;

	public int getLevel() {

		return level;
	}

	LogLevel(int level) {

		this.level = level;
	}
}
