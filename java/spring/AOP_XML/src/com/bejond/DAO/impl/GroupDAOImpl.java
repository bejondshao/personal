package com.bejond.DAO.impl;

import com.bejond.DAO.GroupDAO;
import com.bejond.model.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by bejond on 16-2-18.
 */
//@Component
public class GroupDAOImpl extends AbstractDAOImpl implements GroupDAO {
	@Override
	public Group save(Group group) {
		try {
			group.setName("group1");

			this.getHibernateTemplate().save(group);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//session.close();
		}

		return group;
	}

}
