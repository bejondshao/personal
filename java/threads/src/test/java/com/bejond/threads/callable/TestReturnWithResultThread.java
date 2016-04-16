package com.bejond.threads.callable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by bejond on 4/16/16.
 */
public class TestReturnWithResultThread {

	@Test
	public void testReturnThread() {

		/**
		 * Executors.newCachedThreadPool() returns a ThreadPoolExecutor instance,
		 * ThreadPoolExecutor extends AbstractExecutorService, and
		 * AbstractExecutorService implements ExecutorService.
		 */
		ExecutorService executorService = Executors.newCachedThreadPool();

		ArrayList<Future<String>> futureArrayList =
			new ArrayList<Future<String>>();

		for (int i = 0; i < 100; i++) {

			/**
			 * AbstractExecutorService implements submit(Callable<T>).
			 * submit() invoke call().
			 */
			futureArrayList.add(
				executorService.submit(new ReturnWithResultThread(i)));
		}

		System.out.println("Adding threads is done.");

		for (Future<String> future : futureArrayList) {
			try {
				// get() blocks until completing task
				System.out.println(future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				executorService.shutdown();
			}
		}
	}
}
