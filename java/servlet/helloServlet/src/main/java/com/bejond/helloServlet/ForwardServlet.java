package com.bejond.helloServlet;

import javax.servlet.RequestDispatcher;
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
public class ForwardServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

		req.setAttribute("requestKey", "request值");

		HttpSession session = req.getSession();
		session.setAttribute("sessionKey", "session值");

		ServletContext servletContext = req.getServletContext();
		servletContext.setAttribute("applicationKey", "application值");

		RequestDispatcher requestDispatcher =
			req.getRequestDispatcher("target.jsp");

		requestDispatcher.forward(req, resp); // 服务器跳转(转发)
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

		this.doPost(req, resp);
	}
}
