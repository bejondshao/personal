package com.bejond.spring.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bejond on 15-9-16.
 */
public class MainApp {
	public static void main(String[] args) {
		ApplicationContext applicationContext =
			new ClassPathXmlApplicationContext("Beans.xml");

		HelloWorld helloWorld =
			(HelloWorld) applicationContext.getBean("helloWorld");

		helloWorld.getMessage();
	}

}
