package test;

import com.bejond.model.Category;
import com.bejond.model.Message;
import com.bejond.model.Topic;
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
}
