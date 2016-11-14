package org.bejond.model;

/**
 * Created by Bejond on 2016/11/11.
 */
public class User implements Comparable<User> {

	private int id;

	private String name;

	private int age;

	public User() {

	}

	public User(int id, String name, int age) {

		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public int getAge() {

		return age;
	}

	public void setAge(int age) {

		this.age = age;
	}

	@Override
	public int compareTo(User user) {

		if (this.getAge() < user.getAge()) {
			return -1;
		}
		else if ( this.getAge() > user.getAge() ) {
			return 1;
		}

		return 0;
	}

}
