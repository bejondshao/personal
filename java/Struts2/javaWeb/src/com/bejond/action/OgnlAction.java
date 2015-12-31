package com.bejond.action;

import com.bejond.model.Book;
import com.bejond.model.Cat;
import com.bejond.model.Dog;
import com.bejond.model.Student;
import com.bejond.model.User;
import com.opensymphony.xwork2.ActionSupport;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Created by bejond on 15-12-31.
 */
public class OgnlAction extends ActionSupport {
	private String username;
	private String password;

	private Student student;

	private Book book = new Book();

	private Cat cat;

	private User user;

	private List<User> users = new ArrayList<User>();

	public Map<String, Dog> getDogMap() {
		return dogMap;
	}

	public void setDogMap(Map<String, Dog> dogMap) {
		this.dogMap = dogMap;
	}

	public Set<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(Set<Dog> dogs) {
		this.dogs = dogs;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	private Map<String, Dog> dogMap = new HashMap<String, Dog>();

	private Set<Dog> dogs = new HashSet<Dog>();

	public OgnlAction() {
		users.add(new User("1"));
		users.add(new User("2"));
		users.add(new User("3"));

		dogs.add(new Dog("dog1"));
		dogs.add(new Dog("dog2"));
		dogs.add(new Dog("dog3"));

		dogMap.put("dog100", new Dog("dog100"));
		dogMap.put("dog101", new Dog("dog101"));
		dogMap.put("dog102", new Dog("dog102"));

	}

	public Cat getCat() {
		return cat;
	}

	public void setCat(Cat cat) {
		this.cat = cat;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String m() {
		return "method m from OgnlAction";
	}
}
