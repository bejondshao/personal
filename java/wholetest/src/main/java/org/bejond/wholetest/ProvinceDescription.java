package org.bejond.wholetest;

/**
 * Created by bejond on 4/7/16.
 */
public class ProvinceDescription {
	private String name;
	private double area;

	public ProvinceDescription() {
	}

	public ProvinceDescription(String name, double area) {
		this.name = name;
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "ProvinceDescription{" +
			"name='" + name + '\'' +
			", area=" + area +
			'}';
	}
}
