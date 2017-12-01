package org.bejond.designpattern.interceptorpattern;

public class Client {

	private FilterManager filterManager;

	public FilterManager getFilterManager() {

		return filterManager;
	}

	public void setFilterManager(FilterManager filterManager) {

		this.filterManager = filterManager;
	}

	public void sendMessage(String message) {
		filterManager.execute(message);
	}
}
