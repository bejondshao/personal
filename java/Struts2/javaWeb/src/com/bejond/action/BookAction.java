package com.bejond.action;

import com.bejond.model.Book;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Created by bejond on 15-12-24.
 */
public class BookAction extends ActionSupport implements ModelDriven<Book> {
	private Book book = new Book();

	public String addBook() {
		System.out.print("Book name is: " + book.getName());
		return "addBookSuccess";
	}

	@Override
	public Book getModel() {
		return book;
	}
}
