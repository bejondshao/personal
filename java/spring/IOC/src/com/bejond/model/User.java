package com.bejond.model;

import java.util.List;
import java.util.Properties;

/**
 * Created by bejond on 16-2-3.
 */
public class User {
	private String username;
	private String password;
	private List<Properties> emails;

	public List<Properties> getEmails() {
		return emails;
	}

	public void setEmails(List<Properties> emails) {
		this.emails = emails;
	}

	public User(String username, String password, List<Properties> emails) {
		this.username = username;
		this.password = password;
		this.emails = emails;
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
			"username='" + username + '\'' +
			", password='" + password + '\'' +
			", emails=" + emails +
			'}';
	}

	public void setUsername(String username) {
		this.username = username;
	}
}