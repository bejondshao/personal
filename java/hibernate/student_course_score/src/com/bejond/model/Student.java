package com.bejond.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bejond on 16-1-25.
 */
@Entity
public class Student {
	private int id;
	private String name;
	private Set<Course> courseSet = new HashSet<Course>();

	@ManyToMany
	@JoinTable (
		name = "Score",
		joinColumns = {@JoinColumn (name = "studentId")},
		inverseJoinColumns = {@JoinColumn(name = "courseId")}
	)
	public Set<Course> getCourseSet() {
		return courseSet;
	}

	public void setCourseSet(Set<Course> courseSet) {
		this.courseSet = courseSet;
	}

	@Id
	@GeneratedValue
	@Column(name = "studentId")
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
