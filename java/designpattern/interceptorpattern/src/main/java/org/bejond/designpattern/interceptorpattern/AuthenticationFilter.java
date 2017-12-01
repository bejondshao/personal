package org.bejond.designpattern.interceptorpattern;

public class AuthenticationFilter implements Filter {

	public String doFilter(String message) {
		message = "Auth+" + message;
		System.out.println("Authentication Filter: " + message);
		return message;
	}
}
