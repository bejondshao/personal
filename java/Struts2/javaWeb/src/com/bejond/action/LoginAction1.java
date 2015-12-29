package com.bejond.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * Created by bejond on 15-12-27.
 */
public class LoginAction1 extends ActionSupport {
    private Map request;
    private Map session;
    private Map application;

    public LoginAction1() {
        request = (Map)ActionContext.getContext().get("request");
        session = ActionContext.getContext().getSession();
        application = ActionContext.getContext().getApplication();
    }

    public String execute() {
        request.put("r", "r1");
        session.put("s", "s1");
        application.put("a", "a1");

        return SUCCESS;
    }
}
