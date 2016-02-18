package com.bejond.model;

import org.springframework.context.annotation.Scope;
import org.springframework.mock.staticmock.MockStaticEntityMethods;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by bejond on 16-2-3.
 */
@Component("user")
@Scope("prototype")
@Entity
public class User {
	private int id;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String username;
	private String password;

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