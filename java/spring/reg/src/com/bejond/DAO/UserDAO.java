package com.bejond.DAO;

import com.bejond.model.User;

import java.util.List;

/**
 * Created by bejond on 2/24/16.
 */
public interface UserDAO {
	//public boolean isExisting(User user);
	public User loadUserByName(String username);
	public User loadUserById(int id);
	public User addUser(User user);
	public User addUser(String username, String password);
	public List<User> getUsers();
}
