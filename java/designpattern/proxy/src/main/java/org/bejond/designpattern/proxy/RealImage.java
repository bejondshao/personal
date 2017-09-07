package org.bejond.designpattern.proxy;

public class RealImage implements Image {

	private String fileName;

	public RealImage(String fileName) {

		this.fileName = fileName;
		loadFromDisk(fileName);
	}

	private void loadFromDisk(String fileName) {

		System.out.println("1. Loading " + fileName + " from disk.");
	}

	@Override
	public void load(String fileName) {

		System.out.println("1. File is: " + fileName + ".");
	}
}
