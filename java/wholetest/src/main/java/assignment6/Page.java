package assignment6;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	private double marking;

	/**
	 * use set to avoid duplicate URLs in the same page
	 */
	private Set<Page> childPages = new HashSet<>();

	public Page(String URL, String theTitle, String theText, Elements links) {
		this.URL = URL;
		this.theTitle = theTitle;
		this.theText = theText;
		convertElements(links);
	}

	public Page(String URL, String theTitle) {
		this.URL = URL;
		this.theTitle = theTitle;
	}

	private void convertElements(Elements links) {
		for (Element link : links) {
			String url = link.attr("abs:href");
			String title = trim(link.text(), 35);
			print(" * a: <%s>  (%s)", url, title);
			childPages.add(new Page(url, title));
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
		return childPages;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String URL) {
		this.URL = URL;
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
}
