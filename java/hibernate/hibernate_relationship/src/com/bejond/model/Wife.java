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
public class Wife {
	private int wifeId;
	private String name;
	private Husband husband;

	@OneToOne (mappedBy = "wife")
	public Husband getHusband() {
		return husband;
	}

	public void setHusband(Husband husband) {
		this.husband = husband;
	}

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
