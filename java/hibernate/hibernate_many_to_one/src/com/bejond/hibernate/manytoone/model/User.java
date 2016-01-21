package com.bejond.hibernate.manytoone.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by bejond on 1/20/16.
 */
@Entity
public class User {
	private int userId;
	private String userName;
	private Group group;

	@Id
	@GeneratedValue
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@ManyToOne
	@JoinColumn(name = "groupId") // JoinColumn, not Column
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
}
