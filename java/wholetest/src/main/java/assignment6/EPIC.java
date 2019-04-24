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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Example program to list links from a URL.
 * The three command line arguments may be given in any order:
 * “-u”: this is the URL of the page to begin the search (the seed)
 * “-q”: this is the query string (e.g., “notre dame”)
 * “-m”: this is the maximum number of relevant pages to collect and display
 *
 * --------------------------------------
 *  Approach:
 *  1. Use jsoup fetch homePage, homePage is which the URL of "-uURL". Get all childPages.
 *
 *  2. Use depth-first strategy to explore the web. During exploring, we only crawl the path inside of URL.
 *  E.g. Suppose https://www.abc.com/about/ is the homePage, https://www.abc.com/java/ is out of https://www.abc.com/about/.
 *  https://www.abcd.com/about/ is out of https://www.abc.com/about/ of course.
 *  If we don't set bound, the crawler would be out of control.
 *
 *  3. During exploring, we set visited URL to a static map in case of duplicate crawling.
 *
 *  4. During crawling, we also search the text for query. We search for query, spilt query into key words, considering
 *  stemmer, and also stop words.
 *
 *  5. Store page which contains query or key words into resultPages.
 *  Calculating marking by the way. Marking is the index of sorting when showing result.
 *
 *  6. Showing the resultPages.
 *
 */
public class EPIC {

	private final static String WHITE_SPACE = " ";
	private final static String VERTICAL_BAR = "|";
	private static Map<String, String> argMap = new HashMap<>();
	private static List<String> argList = new ArrayList<>();

	/**
	 * holds visited URLs
	 */
	private static Set<String> visitedURLs = new HashSet<>();

	private static List<Page> resultPages = new java.util.LinkedList<>();

	private static String query;

	private static String removeStopwordQuery;

	private static String stemQuery;

	private static String removeStopwordStemQuery;

	private static String[] keyWords;

	private static String[] stemKeyWords;

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
						if (argument.equals("-q")) {
							argMap.put(argument, arg.substring(2).replace("\"", ""));
						} else {
							argMap.put(argument, arg.substring(2));
						}
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
		query = argMap.get("-q");
		removeStopwordQuery = Stopwords.removeStopWords(query);
		stemQuery = Stopwords.stemString(query);
		removeStopwordStemQuery = Stopwords.removeStopWords(stemQuery);
		keyWords = removeStopwordQuery.split(WHITE_SPACE);
		// make keyWords only search for word not occurrence
		for(int i = 0; i < keyWords.length; i++) {
			keyWords[i] = "\\b" + keyWords[i] + "\\b";
		}

		stemKeyWords = removeStopwordStemQuery.split(WHITE_SPACE);
		for(int i = 0; i < stemKeyWords.length; i++) {
			stemKeyWords[i] = "\\b" + stemKeyWords[i] + "\\b";
		}
		return url;
	}

	public static void main(String[] args) throws IOException {

		Validate.isTrue(args.length == 3, "Usage: supply url \"-u\" to fetch, query \"-q\" to search, and maximum result \"-m\" to show.");

		String url = dealArgs(args);

		Page homePage = new Page(url);
		depthFirst(homePage);
		Collections.sort(resultPages, new Comparator<Page>() {
			/**
			 * sort by marking, descending
			 * @param o1
			 * @param o2
			 * @return
			 */
			@Override
			public int compare(Page o1, Page o2) {
				return o2.getMarking() - o1.getMarking();
			}
		});

		print("====================================================");
		int count = resultPages.size();
		int m = Integer.parseInt(argMap.get("-m"));
		int min = m - count <= 0 ? m : count;
		print("Find %d seaching results. Printing out %d of them.", count, min);
		for (int i = 0; i < min; i++) {
			Page page = resultPages.get(i);
			print("Title: %s ", page.getTheTitle());
			print("URL: %s ", page.getURL());
			print("Related text: %s", page.getDescription());
			print("Marking: %d", page.getMarking());
			print("---------------------------------------------------");
		}
	}

	/**
	 * Depth-first to iterate website
	 */
	public static void depthFirst(Page homePage) throws IOException {
		LinkedList<Page> linkedList = new LinkedList<>();
		Page page = homePage;
		linkedList.addFirst(page);
		while (!linkedList.isEmpty()) {
			page = linkedList.removeFirst();
			int depth = calculateDepth(homePage.getURL(), page.getURL());

			// Skip external links or links out of url. We consider https://www.abc.com/abc/ is out of https://www.abc.com/ab/
			if (depth > 0) {
				boolean fetch = fetchURL(page);

				// only put childPages to linkedList when page is new
				if (fetch) {
					for (Page childPage : page.adjacentTo()) {
						linkedList.addFirst(childPage);
					}
				}
			}
		}
	}

	/**
	 * only fetch hompPage's childPage, if the childPage url domain is different from homepage, depth is 0,
	 * then childPage's childPages would not be fetched or added to Page
	 * @param homePage
	 * @param childPage
	 * @return depth, fetch depth, default is 0
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
	 */
	private static boolean fetchURL(Page page) throws IOException {
		String url = page.getURL();

		if (visitedURLs.contains(url)) {
			// not fetch
			print("Fetched url: %s. Won't fetch again.", url);
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

		Page tempPage = new Page(url, doc.title(), doc.text(), links);

		// copy tempPage to page, this is the right way to copy value
		page.setTheTitle(tempPage.getTheTitle());
		page.setTheText(tempPage.getTheText());

		int marking = calculateMarking(page);
		page.setMarking(marking);

		if (marking > 0) {
			resultPages.add(page);
		}

		// only set childPages when depth is bigger than 0
		page.setChildPages(tempPage.getChildPages());

		// only depth > 0 would return true, then add childPages to LinkedList
		return true;
	}

	/**
	 * Calculate marking for query, and also set related context to page.description
	 * First search for query, then spilt query into key words, and check one by one
	 * If text contains whole query, count 1000.
	 * If text contains stemmed query, count 100.
	 * If text contains one of the key words, count 10.
	 * If the text contains one of the stemmed key words, count 1.
	 * @param page
	 * @return
	 */
	private static int calculateMarking(Page page) {
		String text = page.getTheText();
		int marking = 0;

		String description = findContext(text, query);
		if (description == null && removeStopwordQuery != query) {
			description = findContext(text, removeStopwordQuery);

		} else if (description == null && stemQuery != query) {
			description = findContext(text, stemQuery);

		} else if (description == null && removeStopwordStemQuery != query) {
			description = findContext(text, removeStopwordStemQuery);
		}

		if (description != null) {
			page.setDescription(description);
			marking += 1000;
		} else {
			// search for removeStopword key words


			description = findContext(text, String.join(VERTICAL_BAR, keyWords));
			if (description != null) {
				page.setDescription(description);
				marking += 100;

			}

			// search for removeStopwordStem key words
			if (description == null) {
				description = findContext(text, String.join(VERTICAL_BAR, stemKeyWords));
				if (description != null) {
					page.setDescription(description);
					marking += 10;
				}
			}
		}
		return marking;
	}

	private static String findContext(String text, String patternStr) {
		Pattern pattern = Pattern.compile(patternStr, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(text);
		String context = null;
		if (matcher.find()) {
			int start = matcher.start();
			int beginIndex = start - 30;
			beginIndex = beginIndex < 0 ? 0 : beginIndex;
			int endIndex = matcher.end() + 30;
			endIndex = endIndex > text.length() ? text.length() : endIndex;
			context = text.substring(beginIndex, endIndex);
		}
		return context;
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