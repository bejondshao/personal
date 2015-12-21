package com.bejond.action;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction3 extends ActionSupport {
	
	@Override
	public String execute() {
		return "success";
	}

	public String addName() {
		return "added";
	}

	public String deleteName() {
		return "deleted";
	}
}
