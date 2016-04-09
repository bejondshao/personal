package com.bejond.threads;

/**
 * Created by bejond on 4/9/16.
 */
public class PrintMessage implements Runnable {
	protected int count = 3;

	private int id;

	PrintMessage(int id) {
		this.id = id;
		System.out.println("Thread begin " + id);
	}

	@Override
	public void run() {
		while (count-- > 0) {
			System.out.println("Do print one time." + id);

			//Thread.yield();
		}

		System.out.println("Loop is done.");
	}
}
