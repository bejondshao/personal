package com.bejond.testthread;

import com.bejond.testthread.model.Account;
import org.junit.Test;

/**
 * Created by bejond on 16-3-9.
 */
public class Test1 {
	@Test
	public void testThreads() {
		Thread printChar = new PrintChar('a', 40);
		Thread printChar1 = new PrintChar('b', 60);

		Thread printInt = new Thread(new PrintInt(10));

		printChar.start();
		printInt.start();
		printChar1.start();
	}

	@Test
	public void testWithouSync() {
		WithoutSync withoutSync = new WithoutSync();
		System.out.println(withoutSync.account.getBalance());
	}

	@Test
	public void testDepositAndWithdraw() {
		Account account = new Account(0);
		Thread depositThread = new DepositThread(account);
		Thread withdrawThread = new WithdrawThread(account);

		System.out.println("Thread 1\t\tThread 2\t\tBalance");

		withdrawThread.start();
		depositThread.start();
	}
}
