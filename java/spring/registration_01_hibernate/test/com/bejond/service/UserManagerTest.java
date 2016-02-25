package com.bejond.service;

import com.bejond.model.User;
import com.bejond.service.impl.UserManagerImpl;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by bejond on 2/25/16.
 */
public class UserManagerTest {
	@Test
	public void testIsExisting() throws Exception{
		UserManager userManager = new UserManagerImpl();
		User user = new User();
		user.setUsername("test1");
		boolean exists = userManager.userExists(user);

		// automatic testing
		Assert.assertEquals(true, exists);
	}
}
