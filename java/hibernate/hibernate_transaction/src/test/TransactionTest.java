package test;

import com.bejond.model.Account;
import org.hibernate.LockMode;
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

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by bejond on 16-1-29.
 */
public class TransactionTest {
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
	public void testAddData() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Account account = new Account();
		BigDecimal total = new BigDecimal(1000);
		account.setTotal(total);
		session.save(account);
		session.getTransaction().commit();
	}

	@Test
	public void testOperation1() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Account account = (Account)session.load(Account.class, 1, LockMode.PESSIMISTIC_WRITE);
		BigDecimal total = account.getTotal();

		total = total.add(new BigDecimal(10));

		account.setTotal(total);

		session.getTransaction().commit();
	}

	@Test
	public void testLock() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Account account = session.load(Account.class, 2);

		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		Account account1 = session1.load(Account.class, 2);

		BigDecimal total = account.getTotal();
		BigDecimal total1 = account1.getTotal();
		total = total.add(new BigDecimal(100));
		total1 = total1.subtract(new BigDecimal(80));
		account.setTotal(total);
		account1.setTotal(total1);

		session1.getTransaction().commit();
		System.out.println(account.getVersion());

		session.getTransaction().commit();
		System.out.println(account.getVersion());
		session.close();
		session1.close();
	}
}
