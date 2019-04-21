package assignment6;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Example program to list links from a URL.
 * The three command line arguments may be given in any order:
 * “-u”: this is the URL of the page to begin the search (the seed)
 * “-q”: this is the query string (e.g., “notre dame”)
 * “-m”: this is the maximum number of relevant pages to collect and display
 *
 * --------------------------------------
 *  1. jsoup look into website and find documents
 *  2. write code to iterate documents, depth-first or width-first. Or calculate an index to choose
 *  3. write search code to find out key words
 *  4. write order method to order the contents that contains key words
 */
public class EPIC {

	private static Map<String, String> argMap = new HashMap<>();
	private static List<String> argList = new ArrayList<>();

	static {
		argList.add("-u");
		argList.add("-q");
		argList.add("-m");
	}

	private static String dealArgs(String[] args) {
		for (String arg : args) {
			for (String argument : argList) {
				if (arg.startsWith(argument)) {
					if (arg.length() > 2) {
						argMap.put(argument, arg.substring(2));
					} else {
						throw new RuntimeException("Argument " + argument + "should contain content.");
					}
				}
			}
		}
		String url = argMap.get("-u");
		if (url == null) {
			throw new RuntimeException("Argument \"-u\" is required.");
		}
		return url;
	}

	public static void main(String[] args) throws IOException {
		Validate.isFalse(args.length == 0, "usage: supply url to fetch");

		String url = dealArgs(args);
		print("Fetching %s...", url);

		Document doc = Jsoup.connect(url).get();
		Elements links = doc.select("a[href]");
		Elements media = doc.select("[src]");
		Elements imports = doc.select("link[href]");

		print("\nMedia: (%d)", media.size());
		for (Element src : media) {
			if (src.tagName().equals("img"))
				print(" * %s: <%s> %sx%s (%s)",
					src.tagName(), src.attr("abs:src"), src.attr("width"), src.attr("height"),
					trim(src.attr("alt"), 20));
			else
				print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
		}

		print("\nImports: (%d)", imports.size());
		for (Element link : imports) {
			print(" * %s <%s> (%s)", link.tagName(), link.attr("abs:href"), link.attr("rel"));
		}

		print("\nLinks: (%d)", links.size());
		for (Element link : links) {
			print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
		}
	}

	private static void print(String msg, Object... args) {
		System.out.println(String.format(msg, args));
	}

	private static String trim(String s, int width) {
		if (s.length() > width)
			return s.substring(0, width - 1) + ".";
		else
			return s;
	}
}