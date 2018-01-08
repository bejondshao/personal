package org.bejond.wholetest;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static org.apache.http.HttpHeaders.USER_AGENT;

public class HttpClientExample {

	@Test
	public void testHttpPostRequest() throws IOException {
		String url = "http://localhost:8280/kunlun-cia/rest/cia/searchArrivingReservation";

		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);

		// add header
		post.setHeader("User-Agent", USER_AGENT);

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));
		urlParameters.add(new BasicNameValuePair("cn", ""));
		urlParameters.add(new BasicNameValuePair("locale", ""));
		urlParameters.add(new BasicNameValuePair("caller", ""));
		urlParameters.add(new BasicNameValuePair("num", "12345"));

		try
		{
			post.setEntity(new UrlEncodedFormEntity(urlParameters));
		}
		catch ( UnsupportedEncodingException e )
		{
			e.printStackTrace();
		}

		HttpResponse response = null;
		try
		{
			response = client.execute(post);
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}
		System.out.println("Response Code : "
						+ response.getStatusLine().getStatusCode());

		BufferedReader rd = null;
		try
		{
			rd = new BufferedReader(
							new InputStreamReader(response.getEntity().getContent()));
		}
		catch ( IOException e )
		{
			e.printStackTrace();
		}

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
	}
}
