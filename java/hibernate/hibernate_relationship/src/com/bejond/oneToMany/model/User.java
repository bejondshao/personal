package com.bejond.oneToMany.model;

/**
 * Created by bejond on 16-1-20.
 */
public class User {
	private int userId;
	private String userName;
	private int groupId;

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

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
}
