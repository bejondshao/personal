package com.bejond.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by bejond on 15-12-27.
 */
public class LoginAction3 extends ActionSupport {
    private HttpServletRequest request;
    private HttpSession session;
    private ServletContext application;

    public LoginAction3() {
        request = ServletActionContext.getRequest();
        session = request.getSession();
        application = session.getServletContext();
    }

    public String execute() {
        request.setAttribute("r", "r3");
        session.setAttribute("s", "s3");
        application.setAttribute("a", "a3");

        return SUCCESS;
    }
}
