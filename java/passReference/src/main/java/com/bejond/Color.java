package com.bejond;

import org.junit.Test;

/**
 * Created by bejond on 16-3-30.
 */
public class Color {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Test
	public void testChangeName() {
		Color c1 = new Color();
		c1.setName("Red");
		Color c2 = new Color();
		c2.setName("Blue");
		Color temp = c1;

		c1 = c2;
		c2 = temp;

		System.out.println("c1 name: " + c1.getName());
		System.out.println("c2 name: " + c2.getName());
	}
}
