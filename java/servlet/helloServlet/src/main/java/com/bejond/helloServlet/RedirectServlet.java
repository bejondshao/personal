package com.bejond.helloServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by bejond on 4/24/16.
 */
public class RedirectServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

		req.setAttribute("requestKey", "request值");

		HttpSession session = req.getSession(); // 获取session
		session.setAttribute("sessionKey", "session值");

		ServletContext application = this.getServletContext(); // 获取application
		application.setAttribute("applicationKey", "application值");

		resp.sendRedirect("target.jsp"); // 客户端跳转(重定向)
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

		this.doPost(req, resp);
	}
}
