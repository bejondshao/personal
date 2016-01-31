package com.bejond.model;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by bejond on 1/27/16.
 */
@Entity
@BatchSize(size = 5)
public class Category {
	private int id;
	private String name;

	@Id
	@GeneratedValue
	@Column (name = "categoryId")
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

	public String toString() {
		return id + " - " + name;
	}
}
