package com.bejond.ajax.servlet;

import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by bejond on 5/4/16.
 */
public class InformationServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		// String jsonObject = "{\"name\": \"小喵\", \"age\": 14}";

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "小狗");
		jsonObject.put("age", 18);
		out.print(jsonObject);
		out.flush();
		out.close();
	}
}
