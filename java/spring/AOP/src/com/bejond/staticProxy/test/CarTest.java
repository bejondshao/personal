package com.bejond.staticProxy.test;

import com.bejond.staticProxy.proxy.CarProxy;
import org.junit.Test;

/**
 * Created by bejond on 16-2-15.
 */
public class CarTest {
	@Test
	public void testDriveCar() {
		CarProxy carProxy = new CarProxy();
		carProxy.driveCar();

		carProxy.repairCar();
	}
}
