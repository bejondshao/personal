package com.bejond.service;

import com.bejond.model.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bejond on 16-2-4.
 */
public class UserServiceTest {
	@Test
	public void testAdd() throws Exception {
		ApplicationContext applicationContext =
			new ClassPathXmlApplicationContext(new String[] {"services.xml"});
		// 当参数是一个文件时可以直接使用String,不必用数组.

		UserService userService =
			(UserService)applicationContext.getBean("userService");

		User user = (User)applicationContext.getBean("user");

		userService.addUser(user);
	}
}
