

import com.liferay.portal.kernel.util.StringUtil; // trunk

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bejond on 15-9-30.
 */
public class ReplaceApp {
	public static void main(String[] args) {
		String regex = "(\\w+)\\.trim\\(\\)";
		String str = "sd sdfeb sampleStr.trim();";

		Pattern pattern = Pattern.compile(regex);
		System.out.println(pattern.pattern());
		Matcher mather = pattern.matcher(str);

		String newStr = str;

		while (mather.find()) {
			String firstGroup = mather.group(1);
			newStr = StringUtil.replace(newStr, firstGroup, "StringUtil", mather.start());
			newStr = StringUtil.replace(newStr, "trim()", "trim(" + firstGroup + ")");
			System.out.print(newStr);
		}

	}


}
