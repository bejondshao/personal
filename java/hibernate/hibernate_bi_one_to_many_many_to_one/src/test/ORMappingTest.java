package test;

import com.bejond.hibernate.model.Group;
import com.bejond.hibernate.model.User;
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
public class ORMappingTest {
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
	public void testSaveUser() {

		Group group = new Group();
		group.setGroupName("group1");

		User user = new User();
		user.setUserName("user1");
		user.setGroup(group);

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		//session.save(group); //object references an unsaved transient instance - save the transient instance before flushing

		session.save(user);
		session.getTransaction().commit();

	}

	@Test
	public void testSaveGroup() {

		Group group = new Group();
		group.setGroupName("group1");

		User user = new User();
		user.setUserName("user");
		user.setGroup(group);

		User user1 = new User();
		user1.setUserName("user1");
		user1.setGroup(group);

		group.getUserSet().add(user);
		group.getUserSet().add(user1);

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(group);
		session.getTransaction().commit();

	}

	@Test
	public void testGetUser() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		User user = session.get(User.class, 12);
		Group group = session.get(Group.class, 11);
		session.getTransaction().commit();

	}

	@Test
	public void testLoadUser() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		User user = session.load(User.class, 12);
		user.getGroup().getGroupName();
		session.getTransaction().commit();

	}
}
