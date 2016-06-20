package com.bejond.webserviceClient;

import com.bejond.webservice.HelloWorldWebService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceRef;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Bejond on 2016/6/17.
 */
@RequestScoped
@ManagedBean
public class HelloWorldWebServiceClient {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @WebServiceRef(wsdlLocation = "http://localhost:8180/webservice/HelloWorldWebServiceImpl?wsdl")
    private static HelloWorldWebService helloWorldWebService;

    public String sayHello() {
        URL url = null;
        try {
            url = new URL("http://localhost:8180/webservice/HelloWorldWebServiceImpl?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        QName qName = new QName("http://webservice.bejond.com", "HelloWorldWebServiceImpl");
        Service service = Service.create(url, qName);
        helloWorldWebService = service.getPort(HelloWorldWebService.class);
        return helloWorldWebService.sayHello(name);
    }
}
