package org.bejond.wholetest.stackoverflow;

import org.w3c.dom.Document;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stax.StAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;

public class AvoidSelfClosing {
	private static String test(String source) throws TransformerConfigurationException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.METHOD,"html");
		StringWriter stringWriter = new StringWriter();
		StreamResult result = new StreamResult(stringWriter);
		try {
			transformer.transform(new StreamSource(new ByteArrayInputStream(source.getBytes("UTF-8"))), result);
			String rtn = stringWriter.getBuffer().toString();
			return rtn;
		} catch (Exception e) {

		}

		return source;

	}

	public static void main(String[] args) throws Exception {
		System.out.println(test("<html><head><title></title></head></html>"));
		System.out.println(test("<html  xmlns=\"http://www.w3.org/1999/xhtml\"><head><title></title></head></html>"));
	}
}
