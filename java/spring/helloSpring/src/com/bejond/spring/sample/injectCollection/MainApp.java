package com.bejond.spring.sample.injectCollection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bejond on 15-9-30.
 */
public class MainApp {
	public static void main(String args[]) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
		JavaCollection javaCollection = (JavaCollection)applicationContext.getBean("javaCollection");
		javaCollection.getList();
		javaCollection.getMap();
		javaCollection.getSet();
		javaCollection.getProperty();

	}
}
