package assignment6;

public class URLTrimmer {
	private static String SLASH = "/";
	private static String NUMBER_SIGN = "#";

	public static String removeEndSlash(String url) {
		if (url.endsWith(SLASH)) {
			url = url.substring(0, url.length() - 1);
		}
		return url;
	}

	public static String removeNumberSign(String url) {
		if (url.endsWith(NUMBER_SIGN)) {
			url = url.substring(0, url.length() - 1);
		}
		return url;
	}
}
