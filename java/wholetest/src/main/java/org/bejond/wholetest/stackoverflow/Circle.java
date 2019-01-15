package org.bejond.wholetest.stackoverflow;

public class Circle extends TwoDimensionalShape
{
	public Circle(double radius)
	{
		area = pi * (radius * radius);
		System.out.println(toString(radius));
	}

	public String toString(double var)
	{
		description = "This shape is a circle. It's radius is " + var;
		return description;
	}
}