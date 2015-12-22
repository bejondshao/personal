package com.bejond.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by bejond on 15-12-22.
 */
public class Address extends ActionSupport {
	public String add() {
		return "addSuccess";
	}

	public String delete() {
		return "deleteSuccess";
	}
}
