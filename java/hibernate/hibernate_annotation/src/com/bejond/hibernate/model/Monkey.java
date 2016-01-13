package com.bejond.hibernate.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import java.util.Date;

/**
 * Created by bejond on 16-1-11.
 */

@Entity
@Table(name = "monkey_")
public class Monkey {
	private int id;
	private String name;
	private int age;
	private String food;

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	private Date birthday;

	@Transient // don't create this column in database
	public String getPersonalIssue() {
		return personalIssue;
	}

	public void setPersonalIssue(String personalIssue) {
		this.personalIssue = personalIssue;
	}

	private String personalIssue;

	@Column(name = "food_")
	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Id
	@GenericGenerator (name="generator", strategy="increment")
	@GeneratedValue(generator="generator")
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
}
