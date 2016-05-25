package com.bejond.primefaces;

import javax.faces.bean.ManagedBean;

/**
 * Created by bejond on 2016/5/25.
 */
@ManagedBean
public class BasicView {

	private String text;

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
