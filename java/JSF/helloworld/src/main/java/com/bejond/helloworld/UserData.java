package com.bejond.helloworld;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by bejond on 2016/5/25.
 */
@ManagedBean
@SessionScoped
public class UserData {
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
