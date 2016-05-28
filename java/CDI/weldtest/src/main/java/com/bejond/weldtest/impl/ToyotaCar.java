package com.bejond.weldtest.impl;

import com.bejond.weldtest.Car;

/**
 * Created by bejond on 5/28/16.
 */

public class ToyotaCar implements Car{
	private String carName;

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public ToyotaCar() {
		System.out.println("Creating Toyota car by constructor");
		carName = "ToyotaCar";
	}

	@Override
	public void drive() {
		System.out.println("I'm driving Toyota.");
	}
}
