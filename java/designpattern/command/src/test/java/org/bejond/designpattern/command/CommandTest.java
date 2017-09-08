package org.bejond.designpattern.command;

import org.junit.Test;

public class CommandTest {

	@Test
	public void testCommand() {

		BuyOrder buyOrder = new BuyOrder(new Stock("000060"));
		buyOrder.execute();

		SellOrder sellOrder = new SellOrder(new Stock("000214"));
		sellOrder.execute();
	}
}
