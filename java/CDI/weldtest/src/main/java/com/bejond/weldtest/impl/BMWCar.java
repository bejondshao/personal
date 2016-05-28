package com.bejond.weldtest.impl;

import com.bejond.weldtest.Car;
import com.bejond.weldtest.annotation.BMWCarProducer;

/**
 * Created by bejond on 5/28/16.
 */
@BMWCarProducer
public class BMWCar implements Car {
	private String carName;

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public BMWCar() {
		System.out.println("Creating BMW car by constructor");
	}

	@Override
	public void drive() {
		System.out.println("I'm driving BMW.");
	}
}
