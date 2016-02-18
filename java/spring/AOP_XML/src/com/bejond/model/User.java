package com.bejond.model;

import org.springframework.context.annotation.Scope;
import org.springframework.mock.staticmock.MockStaticEntityMethods;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by bejond on 16-2-3.
 */
@Component ("user")
@Scope ("prototype")
@Entity
public class User {

	@ManyToOne (cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn (name = "groupId")
	public Group getGroup() {
		return group;
	}

	@Id
	@GeneratedValue
	public int getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User{" +
			"password='" + password + '\'' +
			", username='" + username + '\'' +
			'}';
	}

	private Group group;
	private int userId;
	private String password;

	private String username;
}