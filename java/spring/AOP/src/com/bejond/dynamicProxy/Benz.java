package com.bejond.dynamicProxy;

/**
 * Created by bejond on 16-2-15.
 */
public class Benz implements Car {
	@Override
	public void driveCar() {
		System.out.println("I'm driving Benz. ^v^");
		try {
			Thread.sleep(1000);
		}
		catch (Exception e) {}
	}

	@Override
	public void repairCar() {
		System.out.println("I'm repairing Benz. TAT");
		try {
			Thread.sleep(5000);
		}
		catch (Exception e) {}
	}
}
