package com.bejond.hibernate.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class StudentTest2 {
	private static SessionFactory sessionFactory;

	@BeforeClass
	public static void beforeClass() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	@Test
	public void testStudentSave() {
		Student student = new Student();

		student.setName("Xiaoming");
		student.setAge(12);

		Configuration configuration = new Configuration();

		configuration.configure();

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.save(student);

		Transaction transaction = session.getTransaction();

		transaction.commit();

		session.close();

		sessionFactory.close();
	}

	@AfterClass
	public static void afterClass() {
		sessionFactory.close();
	}
}