package com.bejond.DAO.impl;

import com.bejond.DAO.GroupDAO;
import com.bejond.DAO.UserDAO;
import com.bejond.model.Group;
import com.bejond.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by bejond on 16-2-3.
 */
//@Component("userDAOImpl")
public class UserDAOImpl extends AbstractDAOImpl implements UserDAO {
	//private HibernateTemplate hibernateTemplate;

	/*public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}*/

	@Override
	public User save(User user) {
		try {

			/*if (user.getUsername() == null) {
				throw new Exception();
			}*/
			user.setUsername("Zhangfei");
			user.setPassword("test");
			//hibernateTemplate.save(user);
			this.getHibernateTemplate().save(user);

			System.out.println("UserDAO.save()");

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//session.close();
		}
		return user;
	}

}
