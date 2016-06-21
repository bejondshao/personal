package com.bejond.webserviceClient;

import com.bejond.webservice.HelloWorldWebService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Bejond on 2016/6/17.
 */
/*@RequestScoped
@Named*/
@ManagedBean // this is essential
public class HelloWorldWebServiceClient {

	private String name = ""; // this is trying to avoid RPC/Literal parts cannot be null. (WS-I BP R2211)

	private String result;

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getResult() {

		return result;
	}

	public void setResult(String result) {

		this.result = result;
	}

	public static void main(String[] args) {

		URL url = null;

		try
		{
			url = new URL("http://localhost:8180/webservice/HelloWorldWebServiceImpl?wsdl");
		}
		catch ( MalformedURLException e )
		{
			e.printStackTrace();
		}

		//1st argument service URI, refer to wsdl document above
		//2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://webservice.bejond.com/", "HelloWorldWebServiceImplService");

		Service service = Service.create(url, qname);

		HelloWorldWebService helloWorldWebService = service.getPort(HelloWorldWebService.class);

		System.out.println(helloWorldWebService.sayHello("bejondaa"));
	}

	public void sayHelloClient() {

		URL url = null;

		try
		{
			url = new URL("http://localhost:8180/webservice/HelloWorldWebServiceImpl?wsdl");
		}
		catch ( MalformedURLException e )
		{
			e.printStackTrace();
		}

		String namespace = "http://webservice.bejond.com/";
		String serviceName = "HelloWorldWebServiceImplService";
		QName qName = new QName(namespace, serviceName);
		// namespace needs to be the same as targetNamespace in HelloWorldWebServiceImpl
		// serviceName is the implementation class name append "Service"

		Service service = Service.create(url, qName);

		HelloWorldWebService helloWorldWebService = service.getPort(HelloWorldWebService.class);
		result = helloWorldWebService.sayHello(name);
		System.out.println(result);
	}
}
