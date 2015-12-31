package com.bejond.model;

/**
 * Created by bejond on 15-12-22.
 */
public class Cat {
	private Dog friend;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dog getFriend() {
		return friend;
	}

	public void setFriend(Dog friend) {
		this.friend = friend;
	}

	public String miao() {
		return "miao";
	}
	@Override
	public String toString() {
		return "cat's name is: " + name;
	}
}
