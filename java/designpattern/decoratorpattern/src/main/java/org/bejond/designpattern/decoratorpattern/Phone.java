package org.bejond.designpattern.decoratorpattern;

public interface Phone {

	void takePhoto();

	default void photo() {

		System.out.println("Taking photo now. Cheese!");
	}

}
