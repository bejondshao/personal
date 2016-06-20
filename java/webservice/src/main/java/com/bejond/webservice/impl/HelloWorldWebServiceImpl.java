package com.bejond.webservice.impl;

import com.bejond.webservice.HelloWorldWebService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by Bejond on 2016/6/17.
 */
@WebService(endpointInterface = "com.bejond.webservice.HelloWorldWebService",
        targetNamespace = "http://webservice.bejond.com")
public class HelloWorldWebServiceImpl implements HelloWorldWebService {

    @Override
    public String sayHello(String username) {
        return "Hi, " + username + ", welcome to web service world!";
    }

}
