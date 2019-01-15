package org.bejond.wholetest.stackoverflow;

public class PartReverse {

	public static void main(String[] args) {
		String old = "Television";
		String partStr = "visi";
		StringBuilder part = new StringBuilder(partStr);
		part.reverse();
		String newStr = old.replace(partStr, part.toString());
		System.out.println(newStr);
	}
}
