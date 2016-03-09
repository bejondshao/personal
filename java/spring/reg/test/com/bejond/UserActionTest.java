package com.bejond;

import com.bejond.action.UserAction;
import com.bejond.model.User;

import java.util.List;

import junit.framework.Assert;
import org.junit.Test;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Created by bejond on 2/29/16.
 */
public class UserActionTest {
	@Test
	public void testViewUsers() throws Exception {
		ApplicationContext applicationContext =
			new ClassPathXmlApplicationContext("applicationContext.xml");

		UserAction userAction = (UserAction)applicationContext.getBean("userAction");

		userAction.viewUsers();

		Assert.assertEquals(true, userAction.getUserList().size() > 0);
	}
}
