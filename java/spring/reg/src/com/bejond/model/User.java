package com.bejond.model;

import org.springframework.stereotype.Component;

/**
 * Created by bejond on 2/24/16.
 */
@Component
public class User {
	private int userId;
	private String username;
	private String password;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
