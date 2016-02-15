package com.bejond.staticProxy.proxy;

import com.bejond.dynamicProxy.Logger;
import com.bejond.staticProxy.Car;
import com.bejond.staticProxy.Ford;

/**
 * Created by bejond on 16-2-15.
 */
public class CarProxy implements Car {
	private Car car = new Ford();
	private Logger logger = new Logger();

	@Override
	public void driveCar() {
		logger.beforeMethod();
		car.driveCar();
		logger.afterMethod();
	}

	@Override
	public void repairCar() {
		logger.beforeMethod();
		car.repairCar();
		logger.afterMethod();
	}
}
