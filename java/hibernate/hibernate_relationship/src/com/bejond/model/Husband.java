package com.bejond.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Created by bejond on 16-1-18.
 */

@Entity
public class Husband {
	private int husbandId;
	private String name;
	private Wife wife;

	@Id
	@GeneratedValue
	public int getHusbandId() {
		return husbandId;
	}

	public void setHusbandId(int husbandId) {
		this.husbandId = husbandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToOne
	@JoinColumn (name="wifeId")
	public Wife getWife() {
		return wife;
	}

	public void setWife(Wife wife) {
		this.wife = wife;
	}
}
