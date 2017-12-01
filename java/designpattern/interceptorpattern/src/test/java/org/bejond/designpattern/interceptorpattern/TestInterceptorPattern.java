package org.bejond.designpattern.interceptorpattern;

import org.junit.Test;

public class TestInterceptorPattern {

	@Test
	public void testFilter() {
		FilterManager filterManager = new FilterManager(new Target());
		FilterChain filterChain = filterManager.getFilterChain();
		filterChain.addFilter(new AuthenticationFilter());
		filterChain.addFilter(new DebugFilter());
		filterManager.execute("This is brilliant.");
	}
}
