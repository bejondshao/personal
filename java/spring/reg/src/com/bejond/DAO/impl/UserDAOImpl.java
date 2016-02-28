package com.bejond.DAO.impl;

import com.bejond.DAO.UserDAO;
import com.bejond.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import javax.annotation.Resource;

/**
 * Created by bejond on 2/24/16.
 */
@Repository
public class UserDAOImpl implements UserDAO {
	/*private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
*/
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
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
		/*Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String sqlQuery = "select u from User u where username = ?";
		Query query = session.createQuery(sqlQuery).setString(0, username);
		User user = (User)query.uniqueResult();

		return user;*/
		List<User> userList = (List<User>)hibernateTemplate.findByNamedParam(
			"from User u where u.username = :username", "username", username);

		if (userList.size() > 0) {
			return userList.get(0);
		}

		return null;
	}

	@Override
	public User addUser(User user) {
		/*Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();

		return user;*/
		hibernateTemplate.save(user);

		return user;
	}

	@Override
	public User addUser(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		addUser(user);

		return user;
	}
}
