package com.bejond.DAO.impl;

import com.bejond.DAO.AbstractDAO;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by bejond on 2/21/16.
 */
@Component
public class AbstractDAOImpl extends HibernateDaoSupport implements AbstractDAO {
	@Resource (name = "sessionFactory")
	public void setAbstractSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
