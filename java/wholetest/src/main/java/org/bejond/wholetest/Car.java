package org.bejond.wholetest;

public class Car {
	private String name;
	private double price;

	public Car(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car{" +
				"name='" + name + '\'' +
				", price=" + price +
				'}';
	}
}
