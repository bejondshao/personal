package com.bejond.weldtest.bean;

import com.bejond.weldtest.Count;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by bejond on 2016/5/26.
 */
@Named
@RequestScoped
public class Demo {
	@Inject
	private Count count;

	private int a;
	private int b;
	private int result;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getResult() {
		return result;
	}

	public String countResult() {
		result = count.count(a, b);
		return "result";
	}
}
