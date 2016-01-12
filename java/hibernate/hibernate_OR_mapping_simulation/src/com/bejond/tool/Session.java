package com.bejond.tool;

import com.bejond.hibernate.model.Student;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bejond on 16-1-12.
 */
public class Session {
	String tableName = "_student";

	Map<String, String> columnFieldMap = new HashMap<String, String>();

	String[] methodNames;

	public Session() {
		columnFieldMap.put("id", "id");
		columnFieldMap.put("name", "name");
		columnFieldMap.put("age", "age");

		methodNames = new String[columnFieldMap.size()];
	}

	public void save(Student student) throws Exception{
		String sql = generateSQL();

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/hello_hibernate", "root", "");

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		int index = 1;
		for(String methodName : methodNames) {
			Method method = student.getClass().getMethod(methodName);
			Class returnType = method.getReturnType();

			if (returnType.getName().equals("java.lang.String")) {
				preparedStatement.setString(index, (String)method.invoke(student));
			}
			else if (returnType.getName().equals("int")) {
				preparedStatement.setInt(index, (Integer)method.invoke(student));
			}

			index++;

			System.out.println(method + " | " + returnType.getName());
		}

		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}

	private String generateSQL() {
		String keyString = "";
		String values = "";

		int index = 0;

		for (String key : columnFieldMap.keySet()) {
			String value = columnFieldMap.get(key);

			Character character = Character.toUpperCase(value.charAt(0));

			value = character + value.substring(1, value.length());

			System.out.println(value);
			methodNames[index] = "get" + value;

			keyString += key + ",";

			index++;
		}

		keyString = keyString.substring(0, keyString.length() - 1);

		for (int i = 0; i < columnFieldMap.size(); i++) {
			values += "?";
			if ((i + 1) < columnFieldMap.size()) {
				values += ",";
			}
		}

		String sql = "insert into " + tableName + " (" + keyString + ")" +
			" values (" + values + ")";

		System.out.println(sql);

		return sql;
	}

}
