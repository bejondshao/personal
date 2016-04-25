package com.bejond.helloServlet.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by bejond on 4/25/16.
 */
public class LoginFilter implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init LoginFilter");
	}

	public void doFilter(
		ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest)request;

		HttpSession session = httpServletRequest.getSession();
		Object object = session.getAttribute("user");
		String path = httpServletRequest.getServletPath();
		if (object == null && path.indexOf("login") < 0) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if (object != null) {
			HttpServletResponse httpServletResponse = (HttpServletResponse)response;
			httpServletResponse.sendRedirect("main.jsp");
		}
		else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
		System.out.println("destroy LoginFilter");
	}
}
