package org.bejond.wholetest;

import org.junit.Test;

/**
 * Created by Bejond on 2016/11/25.
 */
public class SystemTest {

	@Test
	public void testArraycopy() {

		int[] a = {1, 2, 3, 4, 5};
		int[] b = {10, 20, 30, 40, 50};

		System.arraycopy(a, 1, b, 3, 2); // copy array a from index 1 to array b at index 3, 2 values. result is {10, 20, 30, 2, 3}

		for (int i : b) {
			System.out.println(i);
		}
	}

}
