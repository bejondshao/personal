
package com.bejond.helloworld;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "helloMessage", eager = true)
public class HelloMessage {

	public String sayHello() {

		System.out.println("a");
		return "Hello, Jojo";
	}
}
