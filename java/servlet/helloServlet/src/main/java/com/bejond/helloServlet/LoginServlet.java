package com.bejond.helloServlet;

import com.bejond.helloServlet.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by bejond on 4/25/16.
 */
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

		String username = (String)req.getParameter("username");
		String password = (String)req.getParameter("password");
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		if (user != null) {
			resp.sendRedirect("main.jsp");
		}
		else if ("bejond".equals(username) && "test".equals(password)) {
			User user1 = new User(username, password);

			session.setAttribute("user", user1);

			resp.sendRedirect("main.jsp");
		}
		else {
			req.setAttribute("error", "用户名密码错误");
			req.setAttribute("username", username);
			req.setAttribute("password", password);

			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

		this.doPost(req, resp);
	}
}
