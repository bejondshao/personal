package com.bejond.dynamicProxy.proxy;

import com.bejond.dynamicProxy.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by bejond on 16-2-15.
 */
public class ProxyHandler implements InvocationHandler {
	private Object car;
	private Logger logger = new Logger();

	// 绑定委托对象, 并返回代理类
	public Object bind(Object car) {
		this.car = car;

		// 绑定该类实现的所有接口, 取得代理类
		return Proxy.newProxyInstance(
			car.getClass().getClassLoader(), car.getClass().getInterfaces(),
			this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;

		// 在这里就可以进行所谓的AOP编程了
		// 在调用具体函数方法前,执行功能处理
		logger.beforeMethod();

		result = method.invoke(car, args);

		// 在调用具体函数方法后,执行功能处理
		logger.afterMethod();

		return result;
	}
}
