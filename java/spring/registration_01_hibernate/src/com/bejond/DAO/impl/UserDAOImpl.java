package com.bejond.DAO.impl;

import com.bejond.DAO.UserDAO;
import com.bejond.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by bejond on 2/24/16.
 */
public class UserDAOImpl implements UserDAO {
	private static SessionFactory sessionFactory;

	public UserDAOImpl() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	@Override
	protected void finalize() {
		sessionFactory.close();
	}

	/*@Override
	public boolean isExisting(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String sqlQuery = "select count(*) from User where username = ?";
		Query query = session.createQuery(sqlQuery);
		query.setString(0, user.getUsername());
		long count = (Long)query.uniqueResult();

		return count > 0;
	}*/
	@Override
	public User loadUserByName(String username) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String sqlQuery = "select u from User u where username = ?";
		Query query = session.createQuery(sqlQuery).setString(0, username);
		User user = (User)query.uniqueResult();

		return user;
	}

	@Override
	public User addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();

		return user;
	}
}
