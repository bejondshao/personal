import com.liferay.portal.kernel.util.CharPool;

import java.io.IOException;

/**
 * Created by bejond on 15-12-7.
 */
public class Decode {
	public static void main( String[] args )
	{
		String myString = "H4sIAAAAAAAAAzPUUwjJSFVIzCsuTy1SKMlXyMlMS9VRKAGKleZllqUWFQN5iXkpCqlAdmVJRmZe\n" +
			"uh4vFy+XkZ5Chaubk5tOhZOLK4h0c3J5v2f2sxnrn+xoeLls2pPdDU92drxYP/1xQxNIvbGegltm\n" +
			"UXGJQpCbs0JeaW4S0Lb8NIWC/KISBWdzIwtHE0tjM2NnS0dLY0cTY0dzV3M3I2MjJ1NHUxNHAHzB\n" +
			"pDukAAAA";

		byte[] bytes = decode(myString);

		System.out.println(bytes);
	}
	public static byte[] decode(String base64) {


		int pad = 0;

		for (int i = base64.length() - 1; base64.charAt(i) == CharPool.EQUAL;
		     i--) {

			pad++;
		}

		int length = (base64.length() * 6) / 8 - pad;
		byte[] raw = new byte[611];
		int rawindex = 0;

		for (int i = 0; i < base64.length(); i += 4) {
			int block = getValue(base64.charAt(i)) << 18;

			block += getValue(base64.charAt(i + 1)) << 12;
			block += getValue(base64.charAt(i + 2)) << 6;
			block += getValue(base64.charAt(i + 3));

			for (int j = 0; j < 3 && rawindex + j < raw.length; j++) {
				raw[rawindex + j] = (byte)(block >> 8 * (2 - j) & 0xff);
			}

			rawindex += 3;
		}

		return raw;
	}

	protected static int getValue(char c) {
		if ((c >= CharPool.UPPER_CASE_A) && (c <= CharPool.UPPER_CASE_Z)) {
			return c - 65;
		}

		if ((c >= CharPool.LOWER_CASE_A) && (c <= CharPool.LOWER_CASE_Z)) {
			return (c - 97) + 26;
		}

		if ((c >= CharPool.NUMBER_0) && (c <= CharPool.NUMBER_9)) {
			return (c - 48) + 52;
		}

		if (c == CharPool.PLUS) {
			return 62;
		}

		if (c == CharPool.SLASH) {
			return 63;
		}

		return c != CharPool.EQUAL ? -1 : 0;
	}
}
