package com.bejond.testthread;

/**
 * Created by bejond on 16-3-9.
 */
public class PrintChar extends Thread {
	private char c;
	private int times;

	public PrintChar(char c, int times) {
		this.c = c;
		this.times = times;
	}

	@Override
	public void run() {
		for (int i = 0; i < times; i++) {
			System.out.print(c);
		}
	}
}
