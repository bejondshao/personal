package com.bejond.service.impl;

import com.bejond.DAO.UserDAO;
import com.bejond.model.User;
import com.bejond.service.UserManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;

/**
 * Created by bejond on 2/24/16.
 */
@Service
@Transactional
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
	public boolean userExists(String username) throws Exception {
		User user = userDAO.loadUserByName(username);

		return user != null;
	}

	@Override
	public User addUser(User user) throws Exception {
		return userDAO.addUser(user);
	}

	@Override
	public User addUser(String username, String password, String password2)
		throws Exception {

		if (!password.equals(password2) || userExists(username)) {
			return null;
		}
		else {
			return userDAO.addUser(username, password);
		}
	}

	@Override
	public List<User> viewUsers() {
		return userDAO.getUsers();
	}
}
