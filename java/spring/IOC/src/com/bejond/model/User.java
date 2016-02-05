package com.bejond.model;

/**
 * Created by bejond on 16-2-3.
 */
public class User {
	private String username;
	private String password;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return "User{" +
			"password='" + password + '\'' +
			", username='" + username + '\'' +
			'}';
	}

	public void setUsername(String username) {
		this.username = username;
	}
}