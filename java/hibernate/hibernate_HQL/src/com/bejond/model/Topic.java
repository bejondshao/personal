package com.bejond.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Created by bejond on 1/27/16.
 */
@Entity
@NamedQueries(
	{@NamedQuery(name = "topic.categoryContainsTopic", query = "select distinct t.category.id from Topic t")}
)
@NamedNativeQueries(
	{
		@NamedNativeQuery(name = "categories", query = "select * from category where categoryId > 500 and categoryId < 900")
	}
)
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
