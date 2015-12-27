package com.bejond.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * Created by bejond on 15-12-27.
 */
public class LoginAction2 extends ActionSupport {
    private Map request;
    private Map session;
    private Map application;

    public LoginAction2() {
        request = (Map)ActionContext.getContext().get("request");
        session = ActionContext.getContext().getSession();
        application = ActionContext.getContext().getApplication();
    }

    public String execute() {
        request.put("r", "r2");
        session.put("s", "s2");
        application.put("a", "a2");

        return SUCCESS;
    }
}
