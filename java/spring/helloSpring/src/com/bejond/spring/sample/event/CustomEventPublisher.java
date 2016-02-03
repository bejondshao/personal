package com.bejond.spring.sample.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * Created by bejond on 15-10-8.
 */
public class CustomEventPublisher implements ApplicationEventPublisherAware{

	private ApplicationEventPublisher _publisher;

	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		_publisher = publisher;
	}

	public void publish() {
		CustomEvent ce = new CustomEvent(this);
		_publisher.publishEvent(ce);
	}
}
