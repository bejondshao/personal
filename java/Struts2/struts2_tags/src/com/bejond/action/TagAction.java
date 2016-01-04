package com.bejond.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by bejond on 16-1-4.
 */
public class TagAction extends ActionSupport {
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

	public void setUsername(String username) {
		this.username = username;
	}

	public String execute() {
		this.addFieldError("fielderror.test", "The value of this filed is not valid.");

		return SUCCESS;
	}
}
