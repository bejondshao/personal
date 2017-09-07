package org.bejond.designpattern.proxy;

import java.util.HashMap;
import java.util.Map;

public class ImageProxy implements Image {

	private Map<String, RealImage> cache = new HashMap<>();

	private void display(String fileName) {

		RealImage realImage = loadFromCache(fileName);

		if (realImage == null) {
			System.out.println("2. " + fileName + " is not in cache.");
			realImage = new RealImage(fileName);
			cache.put(fileName, realImage);
		}

		realImage.load(fileName);

		System.out.println("2. Displaying the realImage.");
		System.out.println("");
	}

	private RealImage loadFromCache(String fileName) {

		System.out.println("2. Trying to loading realImage from cache.");
		return cache.get(fileName);
	}

	@Override
	public void load(String fileName) {

		display(fileName);
	}
}
