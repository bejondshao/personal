package assignment6;

import java.util.Iterator;

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

	public Iterable<Page> adjacentTo() {
		return new Iterable<Page>() {
			@Override
			public Iterator<Page> iterator() {
				return null;
			}
		};
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
