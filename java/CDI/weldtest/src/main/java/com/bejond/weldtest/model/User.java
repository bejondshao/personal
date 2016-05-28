package com.bejond.weldtest.model;

import com.bejond.weldtest.Car;
import com.bejond.weldtest.CarType;
import com.bejond.weldtest.annotation.BMWCarProducer;
import com.bejond.weldtest.annotation.CarProducer;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by bejond on 5/28/16.
 */
@Named
@SessionScoped
public class User implements Serializable {

	@Inject @CarProducer(CarType.BENZ)
	private Car benzCar;

	@Inject @BMWCarProducer
	private Car bmwCar;

	@Inject @CarProducer(CarType.TOYOTA)
	private Car toyotaCar;

	public Car getBenzCar() {
		return benzCar;
	}

	public void setBenzCar(Car benzCar) {
		this.benzCar = benzCar;
	}

	public Car getBmwCar() {
		return bmwCar;
	}

	public void setBmwCar(Car bmwCar) {
		this.bmwCar = bmwCar;
	}

	public Car getToyotaCar() {
		return toyotaCar;
	}

	public void setToyotaCar(Car toyotaCar) {
		this.toyotaCar = toyotaCar;
	}
}
