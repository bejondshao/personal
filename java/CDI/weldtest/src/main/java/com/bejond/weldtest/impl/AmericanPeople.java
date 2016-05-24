package com.bejond.weldtest.impl;

import com.bejond.weldtest.CountryType;
import com.bejond.weldtest.People;
import com.bejond.weldtest.annotation.Country;

/**
 * Created by bejond on 2016/5/24.
 */
@Country (CountryType.USA)
public class AmericanPeople implements People {
	public void sayHello() {
		System.out.println("Hello");
	}
}
