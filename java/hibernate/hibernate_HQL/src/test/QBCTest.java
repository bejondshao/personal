package test;

import com.bejond.model.Category;
import com.bejond.model.Topic;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by bejond on 16-1-29.
 */
public class QBCTest {
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
	public void testQBC() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Topic.class)
								.add(Restrictions.gt("id", 500))
								.add(Restrictions.lt("id", 900))
								.createCriteria("category") // this is property of Topic
								.add(Restrictions.between("id", 100, 700));

		for (Object object : criteria.list()) {
			Topic topic = (Topic)object;
			System.out.println(topic);
		}
	}

}
