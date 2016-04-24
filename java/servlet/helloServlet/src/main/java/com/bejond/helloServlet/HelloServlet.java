package com.bejond.helloServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by bejond on 4/24/16.
 */
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

		System.out.println("Call doGet");
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

		// resp.setCharacterEncoding("UTF-8"); // doesn't work
		// resp.setHeader("contentType", "text/html; charset=utf-8"); // doesn't work
		resp.setContentType("text/html; charset=utf-8"); // it works

		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<html>");
		printWriter.println("<head><title>哈喽Servlet</title></head>");
		printWriter.println("Servlet你好吗?");
		printWriter.println("</html>");
	}
}
