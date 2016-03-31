package com.bejond.testthread;

import com.bejond.testthread.model.Account;

/**
 * Created by bejond on 16-3-9.
 */
public class DepositThread extends Thread {
	private Account account;

	public DepositThread(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		while (true) {
			account.deposit((int) (Math.random() * 10) + 1);

			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
