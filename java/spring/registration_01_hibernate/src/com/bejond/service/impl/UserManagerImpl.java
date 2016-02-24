package com.bejond.service.impl;

import com.bejond.DAO.UserDAO;
import com.bejond.DAO.impl.UserDAOImpl;
import com.bejond.model.User;
import com.bejond.service.UserManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

/**
 * Created by bejond on 2/24/16.
 */
public class UserManagerImpl implements UserManager {
	private UserDAO userDAO;

	public UserManagerImpl() {
		userDAO = new UserDAOImpl();
	}
	@Override
	public boolean userExists(User user) throws Exception {
		return userDAO.isExisting(user);
	}

	@Override
	public User addUser(User user) throws Exception {
		return userDAO.addUser(user);
	}
}
