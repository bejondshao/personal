package com.bejond.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by bejond on 15-12-27.
 */
public class LoginAction4 extends ActionSupport implements ServletRequestAware {
    private HttpServletRequest request;
    private HttpSession session;
    private ServletContext application;

    /*public LoginAction2() {
        request = (Map)ActionContext.getContext().get("request");
        session = ActionContext.getContext().getSession();
        application = ActionContext.getContext().getApplication();
    }*/

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
        this.session = request.getSession();
        this.application = session.getServletContext();
    }

    public String execute() {
        request.setAttribute("r", "r4");
        session.setAttribute("s", "s4");
        application.setAttribute("a", "a4");

        return SUCCESS;
    }

}
