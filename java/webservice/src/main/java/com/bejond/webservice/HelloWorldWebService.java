package com.bejond.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * Created by Bejond on 2016/6/17.
 */

/**
 * Endpoint interface
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface HelloWorldWebService {

    @WebMethod
    @WebResult(name = "SayHelloResult")
    String sayHello(@WebParam(name = "Username") String username);

}
