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

	@Override
	public boolean isExisting(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String sqlQuery = "from User where username = ?";
		Query query = session.createQuery(sqlQuery);
		query.setString(0, user.getUsername());
		List result = (ArrayList<User>)query.list();

		return result.size() > 0;
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
