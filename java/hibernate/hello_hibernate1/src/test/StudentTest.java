package test;

import com.bejond.hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by bejond on 16-1-8.
 */
public class StudentTest {
	public static void main(String[] args) {
		Student student = new Student();

		student.setName("Xiaoming");
		student.setAge(12);

		Configuration configuration = new Configuration();

		configuration.configure();

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.save(student);

		Transaction transaction = session.getTransaction();

		transaction.commit();

		session.close();

		sessionFactory.close();
	}
}
