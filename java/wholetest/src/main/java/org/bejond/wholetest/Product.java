package org.bejond.wholetest;

/**
 * Created by bejond on 4/8/16.
 */
public enum Product {
	COMPUTER(Item.Computer.class),
	CAR(Item.Car.class),
	PHONE(Item.Phone.class);

	private Item[] items;

	Product(Class<? extends Item> item) {
		items = item.getEnumConstants();
	}
}
