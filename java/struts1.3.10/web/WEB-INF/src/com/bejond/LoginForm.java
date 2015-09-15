package com.bejond;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Created by bejond on 15-9-14.
 */
public class LoginForm extends ActionForm{
	private String username;
	private String password;

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

	public void reset(ActionMapping mapping, ActionForm form) {
		username = null;
		password = null;
	}
}
