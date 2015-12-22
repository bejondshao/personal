package com.bejond.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by bejond on 15-12-22.
 */
public class UserAction extends ActionSupport {
	private String name;
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String addUser() {
		System.out.println("name = " + name);
		System.out.println("age = " + age);

		return "addUserSuccess";
	}
}
