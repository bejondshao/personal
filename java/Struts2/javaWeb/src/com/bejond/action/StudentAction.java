package com.bejond.action;

import com.bejond.model.Student;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by bejond on 15-12-22.
 */
public class StudentAction extends ActionSupport {
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String addStudent() {
		System.out.println("Student name is : " + student.getName());
		return "addStudentSuccess";
	}
}
