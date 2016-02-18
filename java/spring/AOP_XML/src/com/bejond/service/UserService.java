package com.bejond.service;

import com.bejond.DAO.GroupDAO;
import com.bejond.DAO.UserDAO;
import com.bejond.model.Group;
import com.bejond.model.User;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;


/**
 * Created by bejond on 16-2-3.
 */
@Component("userService")
public class UserService {
	private UserDAO userDAO;
	private GroupDAO groupDAO;

	public GroupDAO getGroupDAO() {
		return groupDAO;
	}

	@Resource (name="groupDAOImpl")
	public void setGroupDAO(GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	@Resource(name="userDAOImpl")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}


	public void addUser(User user) {
		Group group = groupDAO.save(new Group());
		user.setGroup(group);
		userDAO.save(user);
	}

	/*public void addUser(String username, String password) {
		userDAO.save(username, password);
	}*/

	@PostConstruct
	public void init() {
		System.out.println("UserService init()");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("UserService destroy()");
	}
}
