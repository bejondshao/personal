package org.bejond.designpattern.interceptorpattern;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {

	private List<Filter> filterList = new ArrayList<Filter>();

	public void addFilter(Filter filter) {

		filterList.add(filter);
	}

	public boolean removeFilter(Filter filter) {

		return filterList.remove(filter);
	}

	public String execute(String message) {

		for (Filter filter : filterList) {
			message = filter.doFilter(message);
		}
		return message;
	}
}
