package org.bejond.designpattern.interceptorpattern;

public class FilterManager {

	private FilterChain filterChain;

	private Target target;

	public FilterChain getFilterChain() {

		return filterChain;
	}

	public void setFilterChain(FilterChain filterChain) {

		this.filterChain = filterChain;
	}

	public Target getTarget() {

		return target;
	}

	public void setTarget(Target target) {

		this.target = target;
	}

	public FilterManager(Target target) {

		this.filterChain = new FilterChain();
		this.target = target;
	}

	public void execute(String message) {

		message = filterChain.execute(message);
		target.execute(message);

	}
}
