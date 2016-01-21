package com.bejond.hibernate.manytomany.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bejond on 16-1-21.
 */
@Entity
public class Teacher {
	private int teacherId;
	private String name;
	private Set<Student> studentSet = new HashSet<Student>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany
	@JoinTable(
		name = "T_S",
		joinColumns =
			{
				@JoinColumn(name = "teacherId")
			},
		inverseJoinColumns =
			{
				@JoinColumn(name = "studentId")
			}
	)
	public Set<Student> getStudentSet() {
		return studentSet;
	}

	public void setStudentSet(Set<Student> studentSet) {
		this.studentSet = studentSet;
	}

	@Id
	@GeneratedValue
	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
}
