package com.bejond.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by Bejond on 2016/6/17.
 */
@WebService
public interface HelloWorldWebService {

    @WebMethod
    @WebResult(name = "SayHelloResult")
    String sayHello(@WebParam(name = "Username") String username);

}
