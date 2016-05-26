package com.bejond.weldtest.impl;

import com.bejond.weldtest.Count;

import javax.enterprise.inject.Alternative;

/**
 * Created by bejond on 2016/5/26.
 */
@Alternative
public class CountMultiply implements Count {
	public int count(int a, int b) {
		return a * b;
	}
}
