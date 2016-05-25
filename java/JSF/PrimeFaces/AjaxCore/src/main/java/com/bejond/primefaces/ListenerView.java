package com.bejond.primefaces;

import javax.faces.bean.ManagedBean;

/**
 * Created by bejond on 5/25/16.
 */
@ManagedBean
public class ListenerView {
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void handleKeyEvent() {
		text = text.toUpperCase();
	}
}
