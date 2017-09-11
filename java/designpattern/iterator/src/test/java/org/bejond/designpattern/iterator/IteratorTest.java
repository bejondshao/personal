package org.bejond.designpattern.iterator;

import org.junit.Test;

public class IteratorTest {

	@Test
	public void testIterator() {

		String[] names = new String[]{"Bejond", "Alex", "Web", "James"};
		NameRepository nameRepository = new NameRepository();
		nameRepository.setNames(names);

		for (Iterator iterator = nameRepository.getIterator(); iterator.hasNext();) {
			String name = (String)iterator.next();
			System.out.println("Name is: " + name);
		}
	}
}
