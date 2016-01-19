package com.bejond.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by bejond on 16-1-18.
 */
@Entity
public class Wife {
	private int wifeId;
	private String name;

	@Id
	@GeneratedValue
	public int getWifeId() {
		return wifeId;
	}

	public void setWifeId(int wifeId) {
		this.wifeId = wifeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
