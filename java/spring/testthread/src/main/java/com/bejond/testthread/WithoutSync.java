package com.bejond.testthread;

import com.bejond.testthread.model.Account;

/**
 * Created by bejond on 16-3-9.
 */
public class WithoutSync {
	Account account = new Account(0);

	public WithoutSync() {
		for (int i = 0; i < 100; i++) {
			Thread thread = new AddPennyThread();
			thread.start();
		}
	}

	class AddPennyThread extends Thread {

		@Override
		public void run() {
			account.setBalance(account.addBlance(1));
			System.out.println("Balance :" + account.getBalance());
		}
	}
}

