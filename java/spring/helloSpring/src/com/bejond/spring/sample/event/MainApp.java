package com.bejond.spring.sample.event;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bejond on 15-10-8.
 */
public class MainApp {
	public static void main(String[] args) {
		ConfigurableApplicationContext cac = new ClassPathXmlApplicationContext("Beans.xml");
		CustomEventPublisher cep = (CustomEventPublisher)cac.getBean("customEventPublisher");

		cep.publish();
		cep.publish();
	}
}
