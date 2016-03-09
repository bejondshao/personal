package com.bejond.testthread;

/**
 * Created by bejond on 16-3-9.
 */
public class PrintInt implements Runnable {
	private int a;

	public PrintInt(int a) {
		this.a = a;
	}

	@Override
	public void run() {
		for (int i = 0; i < a; i++) {
			System.out.print(" " + i);
		}
	}
}
