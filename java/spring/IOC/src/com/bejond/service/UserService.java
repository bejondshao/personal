package com.bejond.service;

import com.bejond.DAO.UserDAO;
import com.bejond.model.User;

/**
 * Created by bejond on 16-2-3.
 */
public class UserService {
	private UserDAO userDAO;

	public UserService(UserDAO userDAO) {
		System.out.println("Init UserDAO with UserService constructor");
		this.userDAO = userDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		System.out.println("Init UserDAO with setUserDAO()");
		this.userDAO = userDAO;
	}

	public void addUser(User user) {
		userDAO.save(user);
	}

	public void addUser(String username, String password) {
		userDAO.save(username, password);
	}

	public void init() {
		System.out.println("UserService init()");
	}

	public void destroy() {
		System.out.println("UserService destroy()");
	}
}
