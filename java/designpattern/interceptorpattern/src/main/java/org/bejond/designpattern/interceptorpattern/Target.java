package org.bejond.designpattern.interceptorpattern;

public class Target {

	public void execute(String filteredMessage) {
		System.out.println("Executing: " + filteredMessage);
		if (filteredMessage.contains("Auth")) {
			System.out.println("Message Authenticated!");
		}
		if (filteredMessage.contains("Debug")) {
			System.out.println("Echo debug info...");
		}
	}
}
