package org.bejond.wholetest.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Collection {

	@Test
	public void testParallel() {
		List<String> list = new ArrayList<>();
		list.parallelStream().forEach(s -> System.out.println(s));
	}
}
