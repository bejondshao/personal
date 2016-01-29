package test;

import com.bejond.model.Topic;
import org.hibernate.Criteria;
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
}
