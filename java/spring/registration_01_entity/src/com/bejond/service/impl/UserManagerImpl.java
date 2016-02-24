package com.bejond.service.impl;

import com.bejond.model.User;
import com.bejond.service.UserManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

/**
 * Created by bejond on 2/24/16.
 */
public class UserManagerImpl implements UserManager {
	@Override
	public boolean userExists(User user) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root", "");

		String sqlQuery = "select count(*) from User where username = ?";
		PreparedStatement preparedStatement0 = connection.prepareStatement(sqlQuery);
		preparedStatement0.setString(1, user.getUsername());
		ResultSet resultSet = preparedStatement0.executeQuery();
		resultSet.next();

		int count = resultSet.getInt(1);
		preparedStatement0.close();
		connection.close();

		if(count > 0) {
			return true;
		}

		return false;
	}

	@Override
	public User addUser(User user) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root", "");

		String sql = "insert into User values (?, ?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		Random random = new Random();
		preparedStatement.setInt(1, random.nextInt());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.setString(3, user.getUsername());
		preparedStatement.setInt(4, 7);
		preparedStatement.executeUpdate();
		connection.close();

		return user;
	}
}
