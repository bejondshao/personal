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

	public synchronized void deposit(int amount) {
		balance += amount;
		System.out.println("Deposit: " + amount + "\t\t\t\t\t\t" + balance);
		notifyAll();
	}

	public synchronized void withdraw(int amount) {

		while (balance < amount) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		balance -= amount;

		System.out.println("\t\t\t\tWithdraw: " + amount + "\t\t" + balance);
	}
}
