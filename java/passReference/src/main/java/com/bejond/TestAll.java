package com.bejond;

import org.junit.Test;

/**
 * Created by bejond on 16-3-31.
 */
public class TestAll {
	@Test
	public void test1() {
		Color c1 = new Color();
		c1.setName("star");
		Color c2 = new Color();
		c2.setName("moon");
		Color temp = c1;
		c1 = c2;
		c2 = temp;

		System.out.println(c1.getName());
		System.out.println(c2.getName());
	}

	@Test
	public void test2() {
		// 测试循环内变量是不是时实销毁.
		for (int i = 0; i < 10; i++) {
			int a = i;
			String str = new String ("asdf" + i); // 不要在循环里创建变量, 更不要new.
		}
	}
}
