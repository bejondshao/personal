package com.bejond.service;

import com.bejond.DAO.GroupDAO;
import com.bejond.DAO.GroupDAO;
import com.bejond.model.Group;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Created by bejond on 16-2-18.
 */
//@Component
public class GroupService {
	private GroupDAO groupDAO;

	public GroupDAO getGroupDAO() {
		return groupDAO;
	}

	//@Resource (name="groupDAOImpl")
	public void setGroupDAO(GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}

	public void addGroup(Group group) {
		groupDAO.save(group);
	}

	@PostConstruct
	public void init() {
		System.out.println("GroupService init()");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("GroupService destroy()");
	}
}
