package com.bejond.service;

import com.bejond.dao.UserDao;
import com.bejond.model.User;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by bejond on 7/10/16.
 */
@Path ("/userService") // this is for the web service
public class UserService {

	UserDao userDao = new UserDao();

	@GET
	@Path("/users") // this is for web service method
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getUsers() {

		return userDao.getAllUsers();
	}
}
