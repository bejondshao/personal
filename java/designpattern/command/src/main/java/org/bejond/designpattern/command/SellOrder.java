package org.bejond.designpattern.command;

public class SellOrder implements Order {

	private Stock stock;

	public SellOrder(Stock stock) {

		this.stock = stock;
	}

	public void execute() {

		stock.sell();
	}
}
