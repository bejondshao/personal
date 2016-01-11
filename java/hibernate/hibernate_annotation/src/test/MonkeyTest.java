package test;

import com.bejond.hibernate.model.Monkey;
import com.sun.javafx.geom.transform.Identity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.id.IdentityGenerator;

/**
 * Created by bejond on 16-1-8.
 */
public class MonkeyTest {
	public static void main(String[] args) {
		Monkey monkey = new Monkey();

		monkey.setName("King Kong");
		monkey.setAge(27);
		monkey.setFood("Banana");

		Configuration configuration = new Configuration();

		configuration.configure();

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.save(monkey);

		Transaction transaction = session.getTransaction();

		transaction.commit();

		session.close();

		sessionFactory.close();
	}
}
