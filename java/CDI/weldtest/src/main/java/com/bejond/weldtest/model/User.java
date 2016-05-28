package com.bejond.weldtest.model;

import com.bejond.weldtest.Car;
import com.bejond.weldtest.annotation.BMWCarProducer;
import com.bejond.weldtest.annotation.BenzCarProducer;

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

	@Inject @BenzCarProducer
	private Car benzCar;

	@Inject @BMWCarProducer
	private Car bmwCar;

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
}
