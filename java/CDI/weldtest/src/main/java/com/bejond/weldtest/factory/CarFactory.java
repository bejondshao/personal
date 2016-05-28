package com.bejond.weldtest.factory;

import com.bejond.weldtest.Car;
import com.bejond.weldtest.CarType;
import com.bejond.weldtest.annotation.CarProducer;
import com.bejond.weldtest.impl.BenzCar;
import com.bejond.weldtest.impl.ToyotaCar;

import javax.enterprise.inject.Produces;

/**
 * Created by bejond on 5/28/16.
 */
public class CarFactory {
	@Produces @CarProducer(CarType.BENZ)
	public Car createBenzCar() {
		System.out.println("Creating Benz car by producer method createCar()");
		BenzCar benzCar = new BenzCar();
		benzCar.setCarName("benz producer");
		return benzCar;
	}

	@Produces @CarProducer(CarType.TOYOTA)
	public Car createToyotaCar() {
		System.out.println("Creating Toyota car by producer method createCar()");
		ToyotaCar toyotaCar = new ToyotaCar();
		toyotaCar.setCarName("toyota producer");
		return toyotaCar;
	}

}
