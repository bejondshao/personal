package com.bejond.action;

import com.bejond.DTO.UserRegistrationInfo;
import com.bejond.model.User;
import com.bejond.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by bejond on 16-2-26.
 */

/**
 * 比较合适的方式是将Action当做一个bean交给Spring管理,这样Action里的属性和service都
 * 可以通过Spring注入
 */
@Controller
@Scope ("prototype")
public class UserAction extends ActionSupport {
	private UserRegistrationInfo userRegistrationInfo;

	// 添加一个service, 这样所有方法都可以调用. 这个属性的初始化可以交给spring处理
	private UserManager userManager;

	public UserRegistrationInfo getUserRegistrationInfo() {
		return userRegistrationInfo;
	}

	public void setUserRegistrationInfo(
		UserRegistrationInfo userRegistrationInfo) {

		this.userRegistrationInfo = userRegistrationInfo;
	}

	@Resource
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	@Override
	public String execute() throws Exception {
		/**
		 * 其实这里应该用userManager.addUser(userRegistrationInfo),这样新创建个方法.不写了
		 */
		User user = userManager.addUser(
			userRegistrationInfo.getUsername(),
			userRegistrationInfo.getPassword(),
			userRegistrationInfo.getPassword2());

		if (user == null) {
			return "fail";
		}

		return "success";
	}
}
