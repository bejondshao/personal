package org.bejond.wholetest.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	@Test
	public void testAddNull() {
		List<String> list = new ArrayList<>();
		list.add(null);
		list.add("a");
		System.out.println(list.size()); // 2
	}
}
