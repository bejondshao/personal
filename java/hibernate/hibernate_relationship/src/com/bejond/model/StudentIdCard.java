package com.bejond.model;

/**
 * Created by bejond on 16-1-20.
 */
public class StudentIdCard {
	private int id;
	private String name;
	private Student student;

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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
