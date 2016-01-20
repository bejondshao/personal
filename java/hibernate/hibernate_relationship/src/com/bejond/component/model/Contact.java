package com.bejond.component.model;

import javax.persistence.Embedded;

/**
 * Created by bejond on 16-1-20.
 */

public class Contact {
	private String phoneNumber;
	private long zipCode;
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}
}
