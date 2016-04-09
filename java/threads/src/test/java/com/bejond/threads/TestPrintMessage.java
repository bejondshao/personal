package com.bejond.threads;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by bejond on 4/9/16.
 */
public class TestPrintMessage {
	@Test
	public void testPrintMessage() {
		PrintMessage printMessage = new PrintMessage(1);
		PrintMessage printMessage2 = new PrintMessage(2);
		PrintMessage printMessage3 = new PrintMessage(3);
		PrintMessage printMessage4 = new PrintMessage(4);
		PrintMessage printMessage5 = new PrintMessage(5);
		PrintMessage printMessage6 = new PrintMessage(6);

		printMessage.run();
		printMessage2.run();
		printMessage3.run();
		printMessage4.run();
		printMessage5.run();
		printMessage6.run();
	}

	@Test
	public void testThreadPool() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++)
			executorService.execute(new PrintMessage(i));
		executorService.shutdown();
	}
}
