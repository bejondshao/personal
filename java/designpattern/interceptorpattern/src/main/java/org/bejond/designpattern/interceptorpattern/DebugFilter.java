package org.bejond.designpattern.interceptorpattern;

public class DebugFilter implements Filter {

	public String doFilter(String message) {
		message = "Debug+" + message;
		System.out.println("Debug Filter: " + message);
		return message;
	}
}
