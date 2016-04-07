package com.bejond.java8test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * Created by bejond on 16-4-7.
 */

public class TestAll {
	public static FooFuncInterface fooFuncInterface;

	static {
		fooFuncInterface = new FooFuncInterface();
	}

	@Test
	public void testFooFuncInterfaceBeforeJava8() {
		String test = "asdf";

		fooFuncInterface.fooIt(
			new FuncInterface() {
				@Override
				public String foo(String string) {
					return string.toUpperCase();
				}
			},
			test);
	}

	@Test
	public void testFooFuncInterface() {
		String test = "HelLo";

		fooFuncInterface.fooIt(
			(String string) -> {
				string = string.toLowerCase();
				return string;
			},
			test);
	}

	@Test
	public void testSequentialStream() {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 1000000; i++) {
			double d = Math.random() * 1000;
			list.add(d + "");
		}
		long start = System.nanoTime();//获取系统开始排序的时间点
		int count = (int)list.stream().sequential().sorted().count();
		long end = System.nanoTime();//获取系统结束排序的时间点
		long ms = TimeUnit.NANOSECONDS.toMillis(end - start);//得到串行排序所用的时间
		System.out.println(ms + "ms");
	}

	@Test
	public void testStreamParallel() {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 1000000; i++) {
			double d = Math.random() * 1000;
			list.add(d + "");
		}
		long start = System.nanoTime();//获取系统开始排序的时间点
		int count = (int)list.stream().parallel().sorted().count();
		long end = System.nanoTime();//获取系统结束排序的时间点
		long ms = TimeUnit.NANOSECONDS.toMillis(end - start);//得到并行排序所用的时间
		System.out.println(ms + "ms");
	}
}
