package com.bejond.model;

/**
 * Created by bejond on 15-12-31.
 */
public class Dog {
	private String name;

	@Override
	public String toString() {
		return "Dog{" +
			"name='" + name + '\'' +
			'}';
	}

	public Dog(String name) {
		this.name = name;
	}

	public Dog() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
