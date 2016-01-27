package com.bejond.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by bejond on 1/27/16.
 */
@Entity
public class Topic {
	private int id;
	private String title;
	private Category category;

	@Id
	@GeneratedValue
	@Column (name = "topicId")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "categoryId")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
