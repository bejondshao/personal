package assignment6;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

public class Page {

	private String URL;

	private String theTitle;

	/**
	 * A snippet of the text that includes the query terms
	 */
	private String theText;

	/**
	 * description of the page, search result description
	 */
	private String description;

	/**
	 * calculate marking for key words. In order for result sorting
	 */
	private int marking;

	/**
	 * use map to avoid duplicate URLs in the same page
	 */
	private Map<String, Page> childPages = new HashMap<>();

	public Page(String URL, String theTitle, String theText, int marking, Elements links) {
		URL = URLTrimmer.removeNumberSign(URL);
		URL = URLTrimmer.removeEndSlash(URL);
		this.URL = URL;
		this.theTitle = theTitle;
		this.theText = theText;
		this.marking = marking;
		convertElements(links);
	}

	/**
	 * Only set URL, because homepage title might not be particular
	 * @param URL
	 */
	public Page(String URL) {
		URL = URLTrimmer.removeNumberSign(URL);
		URL = URLTrimmer.removeEndSlash(URL);
		this.URL = URL;
	}

	private void convertElements(Elements links) {
		for (Element link : links) {
			String url = link.attr("abs:href");
			if (url.length() > 0) {
				String title = trim(link.text(), 35);

				print(" * a: <%s>  (%s)", url, title);
				childPages.put(url, new Page(url));

			}
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

	public Iterable<Page> adjacentTo() {
		return childPages.values();
	}

	public String getURL() {
		return URL;
	}

	public String getTheTitle() {
		return theTitle;
	}

	public void setTheTitle(String theTitle) {
		this.theTitle = theTitle;
	}

	public String getTheText() {
		return theText;
	}

	public void setTheText(String theText) {
		this.theText = theText;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMarking() {
		return marking;
	}

	public void setMarking(int marking) {
		this.marking = marking;
	}

	public Map<String, Page> getChildPages() {
		return childPages;
	}

	public void setChildPages(Map<String, Page> childPages) {
		this.childPages = childPages;
	}

}
