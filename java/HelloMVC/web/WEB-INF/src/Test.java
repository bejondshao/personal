
/**
 * Created by bejond on 15-11-23.
 */
public class Test {
	public static void main(String[] args) {

		StringBuilder stringBuilder = new StringBuilder("[2]+[4]");

		int [] replaceValues = new int[] {1, 3, 5};

		for ( int i = 0, j = 0; i < stringBuilder.length() && j < replaceValues.length; i++) { // i 用来循环String, j用来循环数组
			char c = stringBuilder.charAt(i); // 获取每个字符的内容

			if ( c >=48 && c <= 57) { // ASCII码48~57对应数字0~9
				if (j < replaceValues.length) {
					c = Character.forDigit(replaceValues[j], 10); // 将数字转换成字母，有很多种方法，你可以尝试下其他的方式．
					stringBuilder.setCharAt(i, c); // 替换数字
					j++;
				}
			}
		}
		System.out.print("The output string is: " + stringBuilder);
	}
}

 