package com.bejond.model;

/**
 * Created by bejond on 15-12-31.
 */
public class User {
	private String name;
	private int age;

	public User(int age) {
		this.age = age;
	}

	public User(String name) {
		this.name = name;
	}

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

	@Override
	public String toString() {
		return "User{" +
			"name='" + name + '\'' +
			'}';
	}
}
