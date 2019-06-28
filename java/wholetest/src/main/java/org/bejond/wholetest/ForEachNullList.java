package org.bejond.wholetest;

import org.junit.Test;

import java.util.List;

public class ForEachNullList {

	public static void main() {
		List<String> list = null;
		for (String string : list) {
			System.out.println(string);
		}
	}
}
