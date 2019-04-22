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
		String query = argMap.get("-q");
		Page homePage = new Page(url);
		depthFirst(homePage, query);
	}

	/**
	 * Depth-first to iterate website
	 */
	public static void depthFirst(Page homePage, String query) throws IOException {
		LinkedList<Page> linkedList = new LinkedList<>();
		Page page = homePage;
		linkedList.addFirst(page);
		while (!linkedList.isEmpty()) {
			page = linkedList.removeFirst();
			fetchURL(page, query, 1); // this doesn't work, because page just a reference to homePage, assign new Page to page doesn't not affect homePage
			System.out.println(page.getTheTitle());
			for (Page childPage : page.adjacentTo()) {
				linkedList.addFirst(childPage);
			}
		}
	}
	/**
	 * Fetch page based on page url
	 * Until there is no child urls or depth is -1
	 * @param page, the page that only contains url
	 * @param depth, fetch depth, default is 1, if url is an external link, depth is 0, continue fetch,
	 *                  but don't fetch it's child urls, so the child urls are -1. If current page doesn't contain
	 *                  any key words, depth set to -1. No more fetch.
	 */
	private static void fetchURL(Page page, String query, int depth) throws IOException {
		String url = page.getURL();
		if (visitedURLs.contains(url)) {
			return;
		}
		print("Fetching %s...", url);
		visitedURLs.add(url);
		Document doc = Jsoup.connect(url).get();
		Elements links = doc.select("a[href]");
		String text = doc.text();
		double marking = calculateMarking(query, text);
		page = new Page(url, doc.title(), text, marking, links);
		if (marking == 0.0) {
			depth = -1;
		}

		//fetchURL()
		if (depth < 0) {

		}

	}

	/**
	 * Calculate marking for query
	 * First search for query, then spilt query into key words, and check one by one
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
		double marking = 0;
		String[] keyWords = query.split(WHITE_SPACE);
		if (text.contains(query)) {
			marking += 100;
		}
		//for ()

		return marking;
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