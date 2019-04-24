import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * http://tutorials.jenkov.com/java-regex/matcher.html
 */
public class MatcherExample {

	public static void main(String[] args) {

		String text =
				"This is the text to be searched " +
						"for occurrences of the http:// pattern.";

		//String patternString = ".*http://.*";
		String patternString = "for occurrence";

		Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);

		Matcher matcher = pattern.matcher(text);
		boolean matches = matcher.matches(); // return true of and only if the entire region sequence matches this matcher's pattern
		System.out.println(matches);
		System.out.println("lookingAt = " + matcher.lookingAt()); // return true if match at the beginning of the text
		String[] split = pattern.split(text);
		for(String element : split) {
			System.out.println("element = " + element);
		}
	}
}
