package test;

import com.bejond.model.Course;
import com.bejond.model.Score;
import com.bejond.model.Student;
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	public void testSaveCourse() {
		Course course = new Course();
		course.setName("math");

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
		session.save(course);
		session.getTransaction().commit();
	}

	@Test
	public void testSaveStudent() {
		Student student = new Student();
		student.setName("stu1");

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
	}

	@Test
	public void testSaveScore() {
		Score score = new Score();

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Student student = session.load(Student.class, 1);
		Course course = session.load(Course.class, 2);

		score.setStudent(student);
		score.setCourse(course);
		score.setScore(96.5);


		session.save(score);
		session.getTransaction().commit();
	}

	@Test
	public void testGetCourseWithStudent() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Student student = session.load(Student.class, 1);
		Set<Course> courseSet = student.getCourseSet();

		Course course = courseSet.iterator().next();
		System.out.println(course.getName());
	}

	@Test
	public void testSave() {
		Student student = new Student();
		student.setName("Lili");
		Course course = new Course();
		course.setName("physical");
		Score score = new Score();
		score.setCourse(course);
		score.setStudent(student);
		score.setScore(92.0);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(student);
		session.save(course);
		session.save(score);

		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void testPattern() {

		String content = "src=\"asdf\"&ss=\"fddf\"";

		Pattern pattern = Pattern.compile("src=\"([\\s\\S]*?)\"|ss=\"([\\s\\S]*?)\"");

		Matcher matcher = pattern.matcher(content);

		List<String> srcList = new ArrayList<>();

		String src = null;

		while (matcher.find()) {
			src = matcher.group();
			String s0 = matcher.group(0);
			String s1 = matcher.group(1);
			String s2 = matcher.group(2);
			System.out.println("group()" + src);
			System.out.println("group(0)" + s0);
			System.out.println("group(1)" + s1);
			System.out.println("group(2)" + s2);
		}

	}
}
