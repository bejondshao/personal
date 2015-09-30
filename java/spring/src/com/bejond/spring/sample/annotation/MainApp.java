package com.bejond.spring.sample.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by bejond on 15-9-30.
 */
public class MainApp {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
		Bridge bridge = (Bridge)applicationContext.getBean("bridge");
		bridge.setLength(129);
	}
}
