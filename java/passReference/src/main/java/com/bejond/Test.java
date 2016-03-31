package com.bejond;

/**
 * Created by bejond on 16-3-30.
 */

public class Test {

    public static void main(String[] args) {

        Balloon red = new Balloon("Red"); //memory reference 50
        Balloon blue = new Balloon("Blue"); //memory reference 100
        System.out.println("red = " + red.toString());
        System.out.println("blue = " + blue.toString());
        swap(red, blue);
        System.out.println("red color="+red.getColor());
        System.out.println("blue color="+blue.getColor());

        foo(blue);
        System.out.println("blue color="+blue.getColor());

    }

    private static void foo(Balloon balloon) { //baloon=100
        balloon.setColor("Red"); //baloon=100
        balloon = new Balloon("Green"); //baloon=200
        balloon.setColor("Blue"); //baloon = 200
    }

    //Generic swap method
    public static void swap(Object o1, Object o2){
        System.out.println("o1 = " + o1.toString());
        System.out.println("o2 = " + o2.toString());
        Object temp = o1;
        System.out.println("temp = " + temp.toString());
        o1=o2;
        System.out.println("o1 = " + o1.toString());
        System.out.println("o2 = " + o2.toString());
        o2=temp;
        System.out.println("o1 = " + o1.toString());
        System.out.println("o2 = " + o2.toString());
    }
}