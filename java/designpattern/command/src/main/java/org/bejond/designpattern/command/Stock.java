package org.bejond.designpattern.command;

public class Stock {

	private String name;

	public Stock(String name) {

		this.name = name;
	}

	public void buy() {

		System.out.println("Buy stock " + name);
	}

	public void sell() {

		System.out.println("Sell stock " + name);
	}
}
