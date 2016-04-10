package com.bejond.ejb;

import java.io.IOException;

/**
 * Created by bejond on 4/10/16.
 */
@javax.servlet.annotation.WebServlet ("helloservlet")
public class HelloServlet extends javax.servlet.http.HttpServlet {
	protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

	}

	protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
		response.getWriter().println("Hello Servlet. This is out put of servlet");
	}
}
