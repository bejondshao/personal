package assignment6;

import java.util.Iterator;

public class Page {
	private String URL;

	private String theTitle;

	private String theText;

	public Iterable<Page> adjacentTo() {
		return new Iterable<Page>() {
			@Override
			public Iterator<Page> iterator() {
				return null;
			}
		};
	}
}
