
package com.bejond.helloworld;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "navigationController", eager = true)
@RequestScoped
public class NavigationController implements Serializable {

	@ManagedProperty(value = "#{param.pageId}")
	private String pageId;

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public String moveToPage2() {

		return "page2";
	}

	public String navigate() {
		if (pageId == null) {
			return "home";
		}
		else if (pageId.equals("3")) {
			return "page3";
		}
		else if ("4".equals(pageId)) {
			return "page4";
		}
		else {
			return "home";
		}
	}
}
