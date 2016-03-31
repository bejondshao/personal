package com.bejond.testthread;

import com.bejond.testthread.model.Account;

/**
 * Created by bejond on 16-3-9.
 */
public class WithdrawThread extends Thread {
	private Account account;

	public WithdrawThread(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		while (true) {
			account.withdraw((int)(Math.random() * 10) + 1);
		}
	}
}
