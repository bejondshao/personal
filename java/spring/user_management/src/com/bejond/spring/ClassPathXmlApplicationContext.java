package com.bejond.spring;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import java.lang.reflect.Method;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bejond on 16-2-4.
 */
public class ClassPathXmlApplicationContext implements BeanFactory {
	private Map<String, Object> beans = new HashMap<String, Object>();

	public ClassPathXmlApplicationContext() throws Exception{
		SAXBuilder saxBuilder = new SAXBuilder();
		Document document = saxBuilder.build(
			this.getClass().getClassLoader().getResourceAsStream("Beans.xml"));

		Element root = document.getRootElement();
		List children = root.getChildren("bean");

		for (int i = 0; i < children.size(); i++) {
			Element element = (Element)children.get(i);
			String id = element.getAttributeValue("id");
			String clazz = element.getAttributeValue("class");
			System.out.println(id + " : " + clazz);
			Object object = Class.forName(clazz).newInstance();
			System.out.println(Class.forName(clazz));
			System.out.println(clazz.getClass());
			beans.put(id, object);

			for (Element propertyElement : element.getChildren("property")) {
				String name = propertyElement.getAttributeValue("name");
				String bean = propertyElement.getAttributeValue("bean");
				String value = propertyElement.getAttributeValue("value");

				String methodName = "set" +
						name.substring(0, 1).toUpperCase() + name.substring(1);

				if (bean != null) {
					Object beanObject = beans.get(bean);

					System.out.println("Method name = " + methodName);

					Method method = object.getClass().getMethod(
						methodName, beanObject.getClass().getInterfaces()[0]);

					method.invoke(object, beanObject);
				}

				if (value != null) {
					System.out.println("Method name = " + methodName);

					Method method = object.getClass().getMethod(
						methodName, value.getClass());

					method.invoke(object, value);
				}
			}
		}
	}

	@Override
	public Object getBean(String name) throws BeansException {
		return beans.get(name);
	}
}
