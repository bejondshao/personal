package com.bejond.filter;

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
 * Created by bejond on 15-12-30.
 */
public class LoginFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init LoginFilter");
		String userName = filterConfig.getInitParameter("userName");

		System.out.println("Hello, " + userName);
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
		HttpSession httpSession = ((HttpServletRequest) servletRequest).getSession();
		String userName = (String)httpSession.getAttribute("userName");

		//判断用户是否登录，进行页面的处理
		if(null == httpSession.getAttribute("user")){
			//未登录用户，重定向到登录页面
			((HttpServletResponse)servletResponse).sendRedirect("loginFilter.jsp");
			return;
		} else {
			//已登录用户，允许访问
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}

	@Override
	public void destroy() {
		System.out.println("Destroy the filter");
	}
}
