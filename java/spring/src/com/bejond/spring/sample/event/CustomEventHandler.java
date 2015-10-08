package com.bejond.spring.sample.event;

import org.springframework.context.ApplicationListener;

/**
 * Created by bejond on 15-10-8.
 */
public class CustomEventHandler implements ApplicationListener<CustomEvent> {
	public void onApplicationEvent(CustomEvent event) {
		System.out.println(event.toString());
	}
}
