package com.bejond.weldtest.factory;

import com.bejond.weldtest.Car;
import com.bejond.weldtest.annotation.BenzCarProducer;
import com.bejond.weldtest.impl.BenzCar;

import javax.enterprise.inject.Produces;

/**
 * Created by bejond on 5/28/16.
 */
public class CarFactory {
	@Produces @BenzCarProducer
	public Car createCar() {
		System.out.println("Creating Benz car by producer method createCar()");
		BenzCar benzCar = new BenzCar();
		benzCar.setCarName("producer");
		return benzCar;
	}
}
