package test;

import com.bejond.model.Category;
import com.bejond.model.Topic;
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

import java.util.Iterator;
import java.util.List;

/**
 * Created by bejond on 16-1-29.
 */
public class CacheTest {
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
	public void testCache() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Category category = session.load(Category.class, 1);
		System.out.println(category);

		Category category2 = session.load(Category.class, 1);
		System.out.println(category2); // load data from cache, no sql
		session.getTransaction().commit();
	}

	@Test
	public void testCacheSessions() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Category category = session.load(Category.class, 1);
		System.out.println(category);
		session.getTransaction().commit();

		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();

		Category category2 = session2.load(Category.class, 1);
		System.out.println(category2); // two sessions, new sql
		session2.getTransaction().commit();
	}

	@Test
	public void testEhcacheSessions() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Topic topic = session.load(Topic.class, 2);
		System.out.println(topic.getTitle()); // 没有用到category, 但是还是获取了,因为使用的eager.
		session.getTransaction().commit();

		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();

		Topic topic2 = session2.load(Topic.class, 2);
		System.out.println(topic2.getTitle()); // 第二次, topic是从cache取的, category依然从数据库取的.
		session2.getTransaction().commit();
	}

	@Test
	public void testQueryCache() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		List<Topic> topicList = (List<Topic>)session.createQuery(
			"from Topic").setCacheable(true).list();

		session.getTransaction().commit();

		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();

		List<Topic> topicList2 = (List<Topic>)session2.createQuery(
			"from Topic").setCacheable(true).list();

		session2.getTransaction().commit();
	}
}
