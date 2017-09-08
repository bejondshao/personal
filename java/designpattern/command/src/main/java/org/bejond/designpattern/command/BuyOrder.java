package org.bejond.designpattern.command;

public class BuyOrder implements Order {

	private Stock stock;

	public BuyOrder(Stock stock) {

		this.stock = stock;
	}

	public void execute() {

		stock.buy();
	}
}
