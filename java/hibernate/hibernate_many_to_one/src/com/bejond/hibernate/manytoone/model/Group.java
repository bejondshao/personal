package com.bejond.hibernate.manytoone.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by bejond on 1/20/16.
 */
@Entity(name = "group_") // Group is keyword of mysql database
public class Group {
	private int groupId;
	private String groupName;

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
