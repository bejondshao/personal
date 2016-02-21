package com.bejond.DAO.impl;

import com.bejond.DAO.AbstractDAO;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by bejond on 2/21/16.
 */
@Component
public class AbstractDAOImpl implements AbstractDAO {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
