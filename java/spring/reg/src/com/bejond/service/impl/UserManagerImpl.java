package com.bejond.service.impl;

import com.bejond.DAO.UserDAO;
import com.bejond.DAO.impl.UserDAOImpl;
import com.bejond.model.User;
import com.bejond.service.UserManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

/**
 * Created by bejond on 2/24/16.
 */
@Component
public class UserManagerImpl implements UserManager {
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	@Resource
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public boolean userExists(User user) throws Exception {
		User user1 = userDAO.loadUserByName(user.getUsername());

		return user1 != null;
	}

	@Override
	public User addUser(User user) throws Exception {
		return userDAO.addUser(user);
	}
}
