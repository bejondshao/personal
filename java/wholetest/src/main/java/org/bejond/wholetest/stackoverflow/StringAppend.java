package org.bejond.wholetest.stackoverflow;

public class StringAppend {

	public String append(String string, String append) {
		String[] array = string.split(" ");
		String result = new String();
		for (String value : array) {
			result += deal(value, append);
			result += " ";
		}
		return result;
	}

	private String deal(String string, String append) {
		return string.substring(string.length() - 1) + string.substring(0, string.length() - 1) + append;
	}

	public static void main(String[] args) {
		String string = "how are you";
		String append = "ah";
		StringAppend stringAppend = new StringAppend();
		String result = stringAppend.append(string, append);

		System.out.println(result);
	}
}
