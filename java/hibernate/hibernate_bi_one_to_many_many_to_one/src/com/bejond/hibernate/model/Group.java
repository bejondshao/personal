package com.bejond.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bejond on 16-1-21.
 */
@Entity(name = "group_")
public class Group {
	private int groupId;
	private String groupName;
	private Set<User> userSet = new HashSet<User>();

	@OneToMany(mappedBy = "group", cascade = {CascadeType.ALL})
	public Set<User> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}

	@Id
	@GeneratedValue
	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
