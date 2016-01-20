package com.bejond.model;

/**
 * Created by bejond on 16-1-20.
 */
public class Student {
	private int id;
	private String name;
	private StudentIdCard studentIdCard;

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

	public StudentIdCard getStudentIdCard() {
		return studentIdCard;
	}

	public void setStudentIdCard(StudentIdCard studentIdCard) {
		this.studentIdCard = studentIdCard;
	}
}
