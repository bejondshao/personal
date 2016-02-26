package com.bejond.DAO;

import com.bejond.model.User;

/**
 * Created by bejond on 2/24/16.
 */
public interface UserDAO {
	//public boolean isExisting(User user);
	public User loadUserByName(String username);
	public User addUser(User user);
}
