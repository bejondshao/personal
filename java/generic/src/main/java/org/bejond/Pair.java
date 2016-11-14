package org.bejond;

/**
 * Created by Bejond on 2016/11/11.
 */
public class Pair<T> {

	private T first;
	private T second;

	public Pair()
	{
		first = null;
		second = null;
	}

	public Pair(T t1, T t2) {

		first = t1;
		second = t2;
	}

	public T getFirst() {

		return first;
	}

	public void setFirst(T first) {

		this.first = first;
	}

	public T getSecond() {

		return second;
	}

	public void setSecond(T second) {

		this.second = second;
	}
}
