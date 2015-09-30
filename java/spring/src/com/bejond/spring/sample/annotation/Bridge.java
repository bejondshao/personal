package com.bejond.spring.sample.annotation;

import org.springframework.beans.factory.annotation.Required;

import java.util.Date;

/**
 * Created by bejond on 15-9-30.
 */
public class Bridge {
	private String name;
	private long length;

	public long getLength() {
		return length;
	}
	@Required
	public void setLength(long length) {
		this.length = length;
	}

	public String getName() {
		return name;
	}
	@Required
	public void setName(String name) {
		this.name = name;
	}
}
