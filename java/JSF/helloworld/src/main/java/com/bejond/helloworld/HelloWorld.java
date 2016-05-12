
package com.bejond.helloworld;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "helloWorld", eager = true)
@RequestScoped
public class HelloWorld {

	@ManagedProperty(value = "#{helloMessage}")
	private HelloMessage hello;

	public HelloMessage getHello() {

		return hello;
	}

	public void setHello(HelloMessage hello) {

		this.hello = hello;
	}

	public HelloWorld() {
		System.out.println("Hello JSF Project");
	}

	public String getMessage() {

		return "Hello JSF";
	}
}
