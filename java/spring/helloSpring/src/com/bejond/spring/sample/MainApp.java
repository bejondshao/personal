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

		helloWorld.setMessage("Hello world 1");
		helloWorld.getMessage();
		HelloWorld helloWorld2 = (HelloWorld) applicationContext.getBean("helloWorld");
		helloWorld2.getMessage();

		HelloWorldChina helloWorldChina= (HelloWorldChina) applicationContext.getBean("helloWorldChina");
		helloWorldChina.getMessage();
		helloWorldChina.getAddress();
	}

}
