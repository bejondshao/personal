package org.bejond.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;
import org.junit.Test;

public class TestReachAttribute {

	@Test
	public void testReachAttribute() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
		Class clazz = Class.forName("org.bejond.reflection.ReachAttribute");
		ReachAttribute reachAttribute = (ReachAttribute) clazz.newInstance();
		Field[] fields = clazz.getFields();
		System.out.println(Arrays.toString(fields));
		Field field = clazz.getDeclaredField("name");
		field.setAccessible(true);
		field.set(reachAttribute, new String("asdf"));
		Field field1 = clazz.getDeclaredField("name");
		field1.setAccessible(true);
		System.out.println(field1.get(reachAttribute));
	}

}
