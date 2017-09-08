package org.bejond.designpattern.chainofresponsibility;

import org.junit.Test;

public class LoggerTest {

	@Test
	public void testLogger() {

		Logger logger = new SimpleLogger();

		logger.log(LogLevel.SIMPLE, "00");
		System.out.println();
		logger.log(LogLevel.ERROR, "aa");
		System.out.println();
		logger.log(LogLevel.INFO, "bb");
		System.out.println();
		logger.log(LogLevel.DEBUG, "cc");
	}
}
