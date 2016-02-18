package com.bejond.DAO.impl;

import com.bejond.DAO.GroupDAO;
import com.bejond.model.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by bejond on 16-2-18.
 */
@Component
public class GroupDAOImpl implements GroupDAO {
	private SessionFactory sessionFactory;

	@Override
	public Group save(Group group) {
		group.setName("group1");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(group);
		session.getTransaction().commit();
		session.close();

		return group;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
