package com.bejond.testthread.model;

/**
 * Created by bejond on 16-3-9.
 */
public class Account {
	private int balance;

	public Account(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int addBlance(int add) {
		return balance + add;
	}
}
