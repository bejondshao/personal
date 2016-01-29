package test;

import java.util.List;
import com.bejond.model.Category;
import com.bejond.model.Message;
import com.bejond.model.MessageInfo;
import com.bejond.model.Topic;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by bejond on 16-1-19.
 */
public class HQLTest {
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
	public void testSchemaExport() {
		ServiceRegistry serviceRegistry =
			new StandardServiceRegistryBuilder().configure().build();

		MetadataImplementor metadataImplementor =
			(MetadataImplementor) new MetadataSources(serviceRegistry).buildMetadata();

		SchemaExport schemaExport = new SchemaExport(serviceRegistry, metadataImplementor);
		schemaExport.create(true, true);
	}

	@Test
	public void testCreateData() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		for (int i = 0; i < 10; i++) {
			Category category = new Category();
			category.setName("Category" + i);
			session.save(category);
			session.flush();

			for (int j = 0; j < 10; j++) {
				Topic topic = new Topic();
				topic.setTitle(category.getName() + " - Topic" + j);
				topic.setCategory(category);
				session.save(topic);
				session.flush();

				for (int k = 0; k < 10; k++) {
					Message message = new Message();
					message.setContent(topic.getTitle() + " - Message" + k);
					message.setTopic(topic);

					session.save(message);
					session.flush();
				}
			}
		}
		session.close();
	}

	@Test
	public void testHQL1() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Category c where c.id > 500");

		List<Category> categoryList = (List<Category>)query.list();

		for (Category category : categoryList) {
			System.out.println("Category name: " + category.getName());
		}

		session.getTransaction().commit();
	}

	@Test
	public void testSelectParameter() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Category c where c.id > :min and c.id < :max");

		query.setParameter("min", 300);
		query.setInteger("max", 800);

		List<Category> categoryList = (List<Category>)query.list();

		for (Category category : categoryList) {
			System.out.println("Category name: " + category.getName());
		}

		session.getTransaction().commit();
	}

	@Test
	public void testHQLPagination() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Category c order by c.name asc");
		query.setMaxResults(5);
		query.setFirstResult(2);

		List<Category> categoryList = (List<Category>)query.list();

		for (Category category : categoryList) {
			System.out.println(category.toString());
		}
	}

	@Test
	public void testHQLColumns() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("select c.id, c.name from Category c order by c.name asc");

		List<Object[]> categoryList = (List<Object[]>)query.list();

		for (Object[] category : categoryList) {
			System.out.println(category[0] + " - " + category[1]);
		}
	}

	@Test  // fetch type 设为 Lazy后不会有第二条sql语句，默认是Eager,会查询category
	public void testHQLJoin() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Topic t where t.category.name = 'Category2'");

		List<Topic> topicList = (List<Topic>)query.list();

		for (Topic topic : topicList) {
			System.out.println(topic.getTitle());
		}
	}

	@Test
	public void testHQLNewObject() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery(
			"select new com.bejond.model.MessageInfo(" +
				"m.id, m.content, m.topic.title, m.topic.category.name)" +
				" from Message m where m.id > 1100");

		for (Object object : query.list()) {
			MessageInfo messageInfo = (MessageInfo)object;
			System.out.println(messageInfo.toString());
		}
	}

	@Test
	public void testHQLJoinProperty() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("select m.content, c.name from Message m join m.topic.category c where m.id > 1105");

		List<Object[]> objectList = query.list();

		for (Object[] object : objectList) {
			System.out.println(object[0] + " & " + object[1]);
		}
	}

	@Test
	public void testHQLObject() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Message m where m = :message");

		Message message = new Message();
		message.setId(8);

		query.setParameter("message", message);
		message = (Message) query.uniqueResult();

		System.out.println(message.toString());
	}
}
