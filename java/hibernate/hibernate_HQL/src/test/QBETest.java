package test;

import com.bejond.model.Topic;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by bejond on 16-1-29.
 */
public class QBETest {
	private static SessionFactory sessionFactory;

	@BeforeClass
	public static void beforeClass() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	@AfterClass
	public static void afterClass() {
		sessionFactory.close();
	}

	@Test
	public void testQBE() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Topic topicExample = new Topic();
		topicExample.setTitle("Category4%");
		Example example = Example.create(
			topicExample).ignoreCase().enableLike();

		Criteria criteria = session.createCriteria(Topic.class)
								.add(Restrictions.like("title", "%topic7"))
								.add(example)
								;

		for (Object object : criteria.list()) {
			Topic topic = (Topic)object;

			System.out.println(topic);
		}
	}

	@Test
	public void testSelect1PlusN() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Topic");
		List<Topic> topicList = (List<Topic>)query.list();

		for (Topic topic : topicList) {
			System.out.println(topic);
		}
	}

	@Test
	public void testSelect1PlusNSolution() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Topic topicExample = new Topic();

		Example example = Example.create(topicExample).ignoreCase();
		Criteria criteria = session.createCriteria(Topic.class).add(example);
		List<Topic> topicList = (List<Topic>)criteria.list();

		for (Topic topic : topicList) {
			System.out.println(topic);
		}
	}

	@Test
	public void testSelect1PlusNSolution2() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Topic.class);
		List<Topic> topicList = (List<Topic>)criteria.list();

		for (Topic topic : topicList) {
			System.out.println(topic);
		}
	}
}
