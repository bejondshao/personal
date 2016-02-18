package com.bejond.model;

import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bejond on 16-2-18.
 */
@Entity
@Component
public class Group {

	@Id
	@GeneratedValue
	public int getGroupId() {
		return groupId;
	}

	public String getName() {
		return name;
	}

	@OneToMany (mappedBy = "group", cascade = {CascadeType.ALL})
	public Set<User> getUserSet() {
		return userSet;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}
	private int groupId;
	private String name;

	private Set<User> userSet = new HashSet<User>();

}
