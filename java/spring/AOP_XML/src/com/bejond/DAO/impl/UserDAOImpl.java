package com.bejond.DAO.impl;

import com.bejond.DAO.GroupDAO;
import com.bejond.DAO.UserDAO;
import com.bejond.model.Group;
import com.bejond.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by bejond on 16-2-3.
 */
@Component("userDAOImpl")
public class UserDAOImpl implements UserDAO {

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private SessionFactory sessionFactory;

	@Override
	public User save(User user) {
		Session session = sessionFactory.openSession();

		try {

			session.beginTransaction();
			user.setUsername("Zhangfei");
			user.setPassword("test");
			session.save(user);
			session.getTransaction().commit();

			System.out.println("UserDAO.save()");

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return user;
	}

}
