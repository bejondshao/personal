package com.bejond.weldtest.impl;

import com.bejond.weldtest.Car;
import com.bejond.weldtest.annotation.BenzCarProducer;

/**
 * Created by bejond on 5/28/16.
 */

public class BenzCar implements Car{
	private String carName;

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public BenzCar() {
		System.out.println("Creating Beaz car by constructor");
		carName = "BenzCar";
	}

	@Override
	public void drive() {
		System.out.println("I'm driving Benz.");
	}
}
