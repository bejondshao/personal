package com.bejond.dynamicProxy.test;

import com.bejond.dynamicProxy.Benz;
import com.bejond.dynamicProxy.Car;
import com.bejond.dynamicProxy.proxy.ProxyHandler;
import org.junit.Test;

/**
 * Created by bejond on 16-2-15.
 */
public class CarTest {
	@Test
	public void testDriveCar() {
		ProxyHandler proxyHandler = new ProxyHandler();

		// 绑定该类实现的所有接口
		Car car = (Car)proxyHandler.bind(new Benz());

		car.driveCar();
		car.repairCar();
	}
}
