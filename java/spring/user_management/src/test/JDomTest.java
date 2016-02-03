package test;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.util.List;

/**
 * Created by bejond on 16-2-3.
 */
public class JDomTest {
	public static void main(String[] args) throws Exception{
		SAXBuilder saxBuilder = new SAXBuilder();
		Document document = saxBuilder.build(JDomTest.class.getClassLoader().getResourceAsStream("test.xml"));
		Element root = document.getRootElement();
		List elementList = root.getChildren("department");

		for (int i = 0; i < elementList.size(); i++) {
			Element element = (Element)elementList.get(i);
			String elementName = element.getAttributeValue("name");
			System.out.println("Department: " + elementName);
			String unit = element.getChildText("unit");
			System.out.println("Unit: " + unit);
			List courseList = element.getChildren("course");
			for (int j = 0; j < courseList.size(); j++) {
				Element course = (Element)courseList.get(j);
				System.out.println("Class: " + course.getText().trim());
			}
		}
	}
}
