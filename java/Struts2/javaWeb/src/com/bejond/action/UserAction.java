package com.bejond.action;

import com.opensymphony.xwork2.ActionSupport;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		if (name == null) {
			Map<String, List<String>> errorMap = new HashMap<String, List<String>>();

			List<String> nameError = new ArrayList<String>();

			nameError.add("name is null");
			nameError.add("name is invalid");

			errorMap.put("name", nameError);

			this.setFieldErrors(errorMap);

			return "addUserError";
		}

		System.out.println("name = " + name);
		System.out.println("age = " + age);

		return "addUserSuccess";
	}
}
