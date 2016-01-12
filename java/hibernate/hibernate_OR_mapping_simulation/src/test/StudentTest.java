package test;

import com.bejond.hibernate.model.Student;
import com.bejond.tool.Session;

/**
 * Created by bejond on 16-1-12.
 */
public class StudentTest {
	public static void main(String[] args) throws Exception{
		Student student = new Student();

		student.setAge(123);
		student.setName("Big Day");
		student.setId(1);

		Session session = new Session();

		session.save(student);
	}
}
