package com.bejond.helloServlet.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Created by bejond on 4/25/16.
 */
public class SessionAttributeListener implements HttpSessionAttributeListener {
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("添加的属性: " + event.getName());
		System.out.println("属性值: " + event.getValue());
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("删除的属性: " + event.getName());
		System.out.println("属性值: " + event.getValue());
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("替换的属性: " + event.getName());
		System.out.println("属性值: " + event.getValue());
	}
}
