package com.bejond.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;
import java.util.Objects;

/**
 * Created by bejond on 15-12-27.
 */
public class LoginAction2 extends ActionSupport implements RequestAware, SessionAware, ApplicationAware {
    private Map<String, Object> request;
    private Map<String, Object> session;
    private Map<String, Object> application;

    /*public LoginAction2() {
        request = (Map)ActionContext.getContext().get("request");
        session = ActionContext.getContext().getSession();
        application = ActionContext.getContext().getApplication();
    }*/

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    @Override
    public void setApplication(Map<String, Object> application) {
        this.application = application;
    }

    public String execute() {
        request.put("r", "r2");
        session.put("s", "s2");
        application.put("a", "a2");

        return SUCCESS;
    }


}
