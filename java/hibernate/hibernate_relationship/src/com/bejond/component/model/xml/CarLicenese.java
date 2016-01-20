package com.bejond.component.model.xml;

import com.bejond.component.model.User;

/**
 * Created by bejond on 16-1-20.
 */
public class CarLicenese {
	private String factory;
	private boolean qualified;
	private long userId;

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public boolean isQualified() {
		return qualified;
	}

	public void setQualified(boolean qualified) {
		this.qualified = qualified;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}
