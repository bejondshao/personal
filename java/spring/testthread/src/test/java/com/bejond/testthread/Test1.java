package com.bejond.testthread;

import org.junit.Test;

/**
 * Created by bejond on 16-3-9.
 */
public class Test1 {
	@Test
	public void testThreads() {
		Thread printChar = new PrintChar('a', 40);
		Thread printChar1 = new PrintChar('b', 60);

		Thread printInt = new PrintInt(10);

		printChar.start();
		printInt.start();
		printChar1.start();
	}
}
