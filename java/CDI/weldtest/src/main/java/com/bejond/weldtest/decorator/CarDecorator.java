package com.bejond.weldtest.decorator;

import com.bejond.weldtest.Car;
import com.bejond.weldtest.CarType;
import com.bejond.weldtest.annotation.BMWCarProducer;
import com.bejond.weldtest.annotation.CarProducer;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 * Created by bejond on 5/29/16.
 */
@Decorator
public abstract class CarDecorator implements Car {
	@Inject
	@Delegate
	@Any
	Car car;

	@Override
	public void drive() {
		car.drive();
		System.out.println("This method is invoked by decorator");
	}
}
