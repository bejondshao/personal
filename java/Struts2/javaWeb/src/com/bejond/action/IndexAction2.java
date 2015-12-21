package com.bejond.action;

import com.opensymphony.xwork2.Action;

public class IndexAction2 implements Action {
	@Override
	public String execute() {
		System.out.println("Action2");
		return "success";
	}
}
