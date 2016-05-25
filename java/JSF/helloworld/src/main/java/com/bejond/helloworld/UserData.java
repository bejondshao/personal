package com.bejond.helloworld;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.util.Map;

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

	public String showResult() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, String> params = facesContext.getExternalContext().getRequestParameterMap();
		data = params.get("name");
		return "results";
	}

	public void actionListener(ActionEvent event) {
		data = (String)event.getComponent().getAttributes().get("username");
	}
}
