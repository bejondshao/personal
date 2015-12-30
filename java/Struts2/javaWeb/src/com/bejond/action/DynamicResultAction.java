package com.bejond.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by bejond on 15-12-30.
 */
public class DynamicResultAction extends ActionSupport {
	private String result;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String execute() {
		if ("1".equals(type)) {
			result = "dynamic_success";
		} else {
			result = "dynamic_error";
		}

		return SUCCESS;
	}

}
