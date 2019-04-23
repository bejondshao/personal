package assignment6;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

	private static List<Page> resultPages = new java.util.LinkedList<>();

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
		Collections.sort(resultPages, new Comparator<Page>() {
			@Override
			public int compare(Page o1, Page o2) {
				return o1.getMarking() - o2.getMarking();
			}
		});
		System.out.println("Printing out search result");
		for (Page page : resultPages) {
			System.out.println(page.getURL());
		}
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
			int depth = calculateDepth(homePage.getURL(), page.getURL());

			// let's skip external links
			if (depth > 0) {
				boolean fetch = fetchURL(page, query, depth);

				// only put childPages to linkedList when page is new
				if (fetch) {
					System.out.println(page.getTheTitle());
					for (Page childPage : page.adjacentTo()) {
						linkedList.addFirst(childPage);
					}
				}
			}
		}
	}

	/**
	 * only fetch hompPage's childPage, if the childPage url domain is different from homepage, depth is 0,
	 * then childPage's childPages would not be added to Page
	 * @param homePage
	 * @param childPage
	 * @return
	 */
	private static int calculateDepth(String homePage, String childPage) {
		int depth = 0;
		try {
			URL aURL = new URL(homePage);
			URL bURL = new URL(childPage);

			// first, domain must be the same
			if (aURL.getHost().equals(bURL.getHost())) {

				// if homePage contains path, only crawls pages under the path
				if (aURL.getPath().length() > 0) {
					if (bURL.getPath().startsWith(aURL.getPath())) {
						depth = 1;
					}
				} else {
					depth = 1;
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return depth;
	}

	/**
	 * Fetch page based on page url
	 * Until there is no child urls or depth is -1
	 * @param page, the page that only contains url
	 * @param depth, fetch depth, default is 1, if url is an external link, depth is 0, continue fetch,
	 *                  but don't fetch it's child urls, so the child urls are -1. If current page doesn't contain
	 *                  any key words, depth set to -1. No more fetch.
	 */
	private static boolean fetchURL(Page page, String query, int depth) throws IOException {
		String url = page.getURL();

		if (visitedURLs.contains(url)) {
			// not fetch
			System.out.println("Fetched url: " + url + ". Won't fetch again.");
			return false;
		}
		print("Fetching %s...", url);

		visitedURLs.add(url);
		Document doc;
		try {
			doc = Jsoup.connect(url).timeout(0).get();
		} catch (Exception e) {
			System.out.println("Error occured while fetching: " + url);
			return false;
		}
		Elements links = doc.select("a[href]");
		String text = doc.text();
		int marking = calculateMarking(query, text);
		Page tempPage = new Page(url, doc.title(), text, marking, links);

		// copy tempPage to page, this is the right way to copy value
		page.setTheTitle(tempPage.getTheTitle());
		page.setTheText(tempPage.getTheText());
		page.setMarking(tempPage.getMarking());

		if (marking > 0) {
			resultPages.add(page);
		}

		// only set childPages when depth is bigger than 0
		page.setChildPages(tempPage.getChildPages());

		// only depth > 0 would return true, then add childPages to LinkedList
		return true;
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
	private static int calculateMarking(String query, String text) {
		if (query == null) {
			return 0;
		}
		int marking = 0;
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