package org.bejond.wholetest.stackoverflow;

public class ShapeArray
{
	Shape array[];
	private final double DEFAULT = 5.0;

	//2D Shapes
	Shape circle;
	Shape square;
	Shape triangle;

	//3D Shapes
	Shape sphere;
	Shape cube;
	Shape tetrahedron;

	//Constructors
	public ShapeArray()
	{
		array = new Shape[6];
		circle = new Circle(DEFAULT);


		fillArray(array,circle,square,triangle,sphere,cube,tetrahedron);
	}

	public ShapeArray(double arg)
	{
		array = new Shape[6];
		circle = new Circle(arg);


		fillArray(array,circle,square,triangle,sphere,cube,tetrahedron);
	}

	public ShapeArray(double arg1,double arg2)
	{
		array = new Shape[6];
		circle = new Circle(arg1);


		fillArray(array,circle,square,triangle,sphere,cube,tetrahedron);
	}

	//Array filling loop
	private void fillArray(Shape[] array,Shape...shapes)
	{
		for(int i=0;i<1;i++)
		{
			array[i] = shapes[i];
			if(shapes[i].getClass().getSuperclass() == TwoDimensionalShape.class)
			{
				System.out.println("2D shape area: " + shapes[i].getArea());
			}
			else
			{
				System.out.printf("3D shape area: %.3f%n3D shape volume: %.3f%n"
								,shapes[i].getArea(),shapes[i].getVolume());
			}
		}
	}
}