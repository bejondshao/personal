package com.bejond.webservice;

/**
 * Created by Bejond on 2016/6/21.
 */

import com.bejond.webservice.impl.HelloWorldWebServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * Endpoint publisher
 */
public class HelloWorldWebServicePublisher {

	public static void main(String[] args) {

		Endpoint.publish("http://localhost:8180/webservice/HelloWorldWebServiceImpl", new HelloWorldWebServiceImpl());
	}
}
