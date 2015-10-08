package com.bejond.spring.sample.event;

import org.springframework.context.ApplicationEvent;

import java.util.Objects;

/**
 * Created by bejond on 15-10-8.
 */
public class CustomEvent extends ApplicationEvent{
	public CustomEvent(Object event) {
		super(event);
	}
	public String toString() {
		return "My custom event. " + this.getClass();
	}
}
