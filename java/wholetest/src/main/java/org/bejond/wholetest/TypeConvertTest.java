package org.bejond.wholetest;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TypeConvertTest {

	@Test
	public void testTypeConvert() {
		ArrayList<String> arrayList = new ArrayList();
		List list = (List) arrayList;
		list.add("asdf");
		arrayList.get(0);
		Assert.assertSame(list, arrayList);
	}
}
