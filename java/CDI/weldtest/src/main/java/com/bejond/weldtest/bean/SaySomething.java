package com.bejond.weldtest.bean;

import com.bejond.weldtest.CountryType;
import com.bejond.weldtest.People;
import com.bejond.weldtest.annotation.Country;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by bejond on 2016/5/24.
 */
@Named
public class SaySomething {
	@Inject
	@Country (CountryType.USA)
	private People americanPeople;

	public People getAmericanPeople() {
		return americanPeople;
	}

	public void setAmericanPeople(People americanPeople) {
		this.americanPeople = americanPeople;
	}

	public void say() {
		americanPeople.sayHello();
	}
}
