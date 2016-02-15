package com.bejond.staticProxy;

/**
 * Created by bejond on 16-2-15.
 */
public class Ford implements Car {
	@Override
	public void driveCar() {
		System.out.println("I'm driving Ford. ^v^");
	}

	@Override
	public void repairCar() {
		System.out.println("I'm repairing Ford. TAT");
	}
}
