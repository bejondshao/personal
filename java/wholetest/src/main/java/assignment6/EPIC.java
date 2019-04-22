package assignment6;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

	private final static String WHITE_SPACE = " ";
	private static Map<String, String> argMap = new HashMap<>();
	private static List<String> argList = new ArrayList<>();

	/**
	 * holds visited URLs
	 */
	private static Set<String> visitedURLs = new HashSet<>();

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

		fetchURL(url, argMap.get("-q"), 1);

		print("\nBody: (%s)", text);
	}

	/**
	 * Fetch url recursively, until there is no child urls or depth is 0
	 * @param url
	 * @param depth, fetch depth, default is 1, if url is an external link, depth is 0, continue fetch,
	 *                  but don't fetch it's child urls, so the child urls are -1. If current page doesn't contain
	 *                  any key words, depth set to -1. No more fetch.
	 */
	private static void fetchURL(String url, String query, int depth) throws IOException {
		if (depth >= 1) {
			print("Fetching %s...", url);
			Document doc = Jsoup.connect(url).get();
			Elements links = doc.select("a[href]");
			String text = doc.text();
			double marking = calculateMarking(query);
			Page homePage = new Page(url, doc.title(), text, links);
		}
	}

	/**
	 * Calculate marking for query, first search for query, then spilt query into key words, and check one by one
	 * If text contains whole query, count 100, if text contains one of the key words, count 10, if the text contains
	 * one of the key words more than one time, count 1
	 * @param query
	 * @param text
	 * @return
	 */
	private static double calculateMarking(String query, String text) {
		if (query == null) {
			return 0;
		}

		String[] keyWords = query.split(WHITE_SPACE);
		String[]
		for ()
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