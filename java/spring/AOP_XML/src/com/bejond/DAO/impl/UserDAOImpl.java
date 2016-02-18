package com.bejond.DAO.impl;

import com.bejond.DAO.UserDAO;
import com.bejond.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by bejond on 16-2-3.
 */
@Component("userDAOImpl")
public class UserDAOImpl implements UserDAO {
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Resource
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(User user) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			connection.createStatement().executeUpdate(
				"insert into user values (null, 'aa', 'password')");

			connection.close();
			System.out.println("UserDAO.save()");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {

		}
	}

	/*@Override
	public void save(String username, String password) {
		System.out.println("UserDAO.save(String, String)");
	}*/
}
