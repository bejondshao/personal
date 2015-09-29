package com.bejond.spring.sample;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.Objects;

/**
 * Created by bejond on 15-9-29.
 */
public class InitHelloWorld implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeforeInitialization: " + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanNmae) throws BeansException {
		System.out.println("AfterInitializaiton: " + beanNmae);
		return bean;
	}
}
