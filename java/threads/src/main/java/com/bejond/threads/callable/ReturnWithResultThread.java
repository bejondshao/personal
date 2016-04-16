package com.bejond.threads.callable;

import java.util.concurrent.Callable;

/**
 * Created by bejond on 4/16/16.
 *
 * If we want a thread return a value, we can make the thread implement
 * Callable<T>.
 */
public class ReturnWithResultThread implements Callable {
	private long id;

	public ReturnWithResultThread(long id) {
		this.id = id;
	}

	@Override
	public Object call() throws Exception {
		System.out.println("Invoke call()" + id);
		return "The thread return result is " + id;
	}
}
