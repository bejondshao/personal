package com.bejond.weldtest.bean;

import com.bejond.weldtest.People;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by bejond on 2016/5/24.
 */
@Named
public class SaySomething {
	private People people;

	public People getPeople() {
		return people;
	}

	@Inject
	public void setPeople(People people) {
		this.people = people;
	}

	public void say() {
		people.sayHello();
	}
}
