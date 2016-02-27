package com.bejond.action;

import com.bejond.model.User;
import com.bejond.service.UserManager;
import com.bejond.service.impl.UserManagerImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by bejond on 16-2-26.
 */

/**
 * 比较合适的方式是将Action当做一个bean交给Spring管理,这样Action里的属性和service都
 * 可以通过Spring注入
 */
public class UserAction extends ActionSupport {
	private String username;
	private String password;
	private String password2;

	// 添加一个service, 这样所有方法都可以调用. 这个属性的初始化可以交给spring处理
	private UserManager userManager = new UserManagerImpl();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	@Override
	public String execute() throws Exception {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		if (userManager.userExists(user)) {
			return "fail";
		}
		else {
			userManager.addUser(user);
		}
		/**
		 *  其实这里有判断user是否存在,属于业务逻辑,理应放在UserManager里处理.比较合
		 * 适的方式是在UserManager的addUser方法里判断user是否存在, 然后或者报异常,
		 * 或者返回特定值
		 */
		return "success";
	}
}
