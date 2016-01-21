package com.bejond.hibernate.manytoone.model.xml;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by bejond on 1/20/16.
 */

public class SubRole {
	private int subRoleId;
	private String subRoleName;
	private Role role;

	public int getSubRoleId() {
		return subRoleId;
	}

	public void setSubRoleId(int subRoleId) {
		this.subRoleId = subRoleId;
	}

	public String getSubRoleName() {
		return subRoleName;
	}

	public void setSubRoleName(String subRoleName) {
		this.subRoleName = subRoleName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
