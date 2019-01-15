package org.bejond.wholetest.stackoverflow;

public class Substring {
	public static void main(String[] args) {
/*		String text = "lady_gaga";
		String[][] result = new String[5][text.length()];

		for(int i = 0; i < result.length; i++) {
			int k = i + 1;
			for(int j = 0; j < text.length() - i; j++) {
				result[i][j] = text.substring(j, j + k);
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}*/
		String text = "lady_gaga";
		String[] result = new String[100];

		int index = 0;
		for(int i = 0; i < 5; i++) {
			int k = i + 1;
			for(int j = 0; j < text.length() - i; j++) {
				result[index] = text.substring(j, j + k);
				System.out.print(result[index] + " ");
				index++;
			}
			System.out.println();
		}
	}
}
