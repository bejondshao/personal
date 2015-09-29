package com.bejond.spring.sample.innerBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bejond on 15-9-29.
 */
public class MainApp {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
		TextManager textManager = (TextManager)applicationContext.getBean("textManager");
		textManager.checkSpell();
	}
}
