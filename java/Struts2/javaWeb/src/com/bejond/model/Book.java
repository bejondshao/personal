package com.bejond.model;

/**
 * Created by bejond on 15-12-24.
 */
public class Book {
	private String name;
	private double price;
	private int pages;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
