package com.bejond.ajax.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by bejond on 5/3/16.
 */
public class TimerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

		Date date = new Date();
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();

		out.print(date);
		out.flush();
		out.close();
	}
}
