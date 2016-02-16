package com.bejond.DAO.impl;

import com.bejond.DAO.UserDAO;
import com.bejond.model.User;
import org.springframework.stereotype.Component;

/**
 * Created by bejond on 16-2-3.
 */
@Component("userDAOImpl")
public class UserDAOImpl implements UserDAO {
	@Override
	public void save(User user) {
		System.out.println(user);
		System.out.println("UserDAO.save()");
	}

	/*@Override
	public void save(String username, String password) {
		System.out.println("UserDAO.save(String, String)");
	}*/
}
