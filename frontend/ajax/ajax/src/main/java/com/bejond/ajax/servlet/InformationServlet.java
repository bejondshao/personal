package com.bejond.ajax.servlet;

import net.sf.json.JSONArray;
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

		String action = req.getParameter("action");

		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		// String jsonObject = "{\"name\": \"小喵\", \"age\": 14}";

		JSONObject jsonObject = new JSONObject();

		if ("getInfo".equals(action)) {
			getInfo(req, resp, jsonObject);
		}
		else if ("getStudents".equals(action)){
			getStudents(req, resp, jsonObject);
		}
		else if ("checkUsername".equals(action)) {
			checkUsername(req, resp, jsonObject);
		}
		else if ("loadCities".equals(action)) {
			loadCities(req, resp, jsonObject);
		}

		out.print(jsonObject);
		out.flush();
		out.close();
	}

	private void getStudents(HttpServletRequest req, HttpServletResponse resp,
			JSONObject jsonObject) throws ServletException, IOException {

		JSONArray jsonArray = new JSONArray();
		JSONObject student1 = new JSONObject();
		JSONObject student2 = new JSONObject();
		JSONObject student3 = new JSONObject();
		student1.put("name", "刘备");
		student2.put("name", "关羽");
		student3.put("name", "张飞");
		student1.put("age", "23");
		student2.put("age", "22");
		student3.put("age", "21");

		JSONObject score1 = new JSONObject();
		JSONObject score2 = new JSONObject();
		JSONObject score3 = new JSONObject();

		score1.put("chinese", 86);
		score1.put("maths", 98);
		score1.put("english", 95);
		score2.put("chinese", 61);
		score2.put("maths", 60);
		score2.put("english", 64);
		score3.put("chinese", 91);
		score3.put("maths", 92);
		score3.put("english", 93);

		student1.put("score", score1);
		student2.put("score", score2);
		student3.put("score", score3);

		jsonArray.add(student1);
		jsonArray.add(student2);
		jsonArray.add(student3);

		jsonObject.put("students", jsonArray);
	}

	protected void getInfo(HttpServletRequest req, HttpServletResponse resp,
			JSONObject jsonObject) throws ServletException, IOException {

		jsonObject.put("name", "小狗");
		jsonObject.put("age", 18);
	}

	protected void checkUsername(HttpServletRequest req, HttpServletResponse resp,
			JSONObject jsonObject) throws ServletException, IOException {

		String username = req.getParameter("username");

		if ("haha".equals(username)) {
			jsonObject.put("exists", true);
		}
	}

	protected void loadCities(HttpServletRequest req, HttpServletResponse resp,
			JSONObject jsonObject) throws ServletException, IOException {

		String provinceId = req.getParameter("provinceId");
		JSONArray cities = new JSONArray();
		JSONObject temp = new JSONObject();

		switch (Integer.parseInt(provinceId)) {
			case 1: {
				temp.put("cityId", 1);
				temp.put("name", "沈阳");
				cities.add(temp);
				temp.clear();

				temp.put("cityId", 2);
				temp.put("name", "大连");
				cities.add(temp);
				temp.clear();

				temp.put("cityId", 3);
				temp.put("name", "丹东");
				cities.add(temp);
				temp.clear();

				break;
			}

			case 2: {
				temp.put("cityId", 4);
				temp.put("name", "吉林");
				cities.add(temp);
				temp.clear();

				temp.put("cityId", 5);
				temp.put("name", "长春");
				cities.add(temp);
				temp.clear();

				temp.put("cityId", 6);
				temp.put("name", "延吉");
				cities.add(temp);
				temp.clear();

				break;
			}

			case 3: {
				temp.put("cityId", 7);
				temp.put("name", "哈尔滨");
				cities.add(temp);
				temp.clear();

				temp.put("cityId", 8);
				temp.put("name", "牡丹江");
				cities.add(temp);
				temp.clear();

				temp.put("cityId", 9);
				temp.put("name", "大庆");
				cities.add(temp);
				temp.clear();

				break;
			}
		}

		jsonObject.put("cities", cities);
	}
}
