package org.bejond.wholetest.stackoverflow;

import java.util.ArrayList;
import java.util.Stack;

class MyArrayStack<E> extends Stack<E> {

	int key, data, size = 0;

	int[] array = new int[12];

	int element;

	public E push(E e) {

		//data = (int) e;
		array[size] = data;
		size++;
		System.out.println("The Element is inserted Successfully");

		return e;
	}
}