package org.bejond.wholetest.stackoverflow;

import java.util.*;
import java.lang.*;
import java.io.*;


public class SetComparison
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scnr = new Scanner(System.in);
		String str = scnr.nextLine();

		String[] allNums = str.split("\\s+");

		int array1Length = Integer.valueOf(allNums[0]);
		int array2Length = Integer.valueOf(allNums[array1Length + 1]);

		double array1[] = new double[array1Length];
		double array2[] = new double[array2Length];

		for (int i = 0; i < array1Length; i++) {
			array1[i] = Double.valueOf(allNums[i + 1]);
		}
		for (int i = 0; i < array2Length; i++) {
			array2[i] = Double.valueOf(allNums[array1Length + i + 2]);
		}

		if (Arrays.equals(array1, array2)) {
			System.out.println("set one and set two are equal");
		} else {
			System.out.println("set one and set two are not equal");
		}
	}
}