package com.bejond.service;

import com.bejond.DAO.UserDAO;
import com.bejond.model.User;

/**
 * Created by bejond on 16-2-3.
 */
public class UserService {
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void addUser(User user) {
		userDAO.save(user);
	}

	public void addUser(String username, String password) {
		userDAO.save(username, password);
	}
}
