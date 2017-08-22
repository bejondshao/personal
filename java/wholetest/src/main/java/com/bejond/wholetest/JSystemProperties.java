package com.bejond.wholetest;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by bejond on 17-4-10.
 */
public class JSystemProperties {
	public static void main(String[] args) {
		System.getProperties().list(System.out);
		try
		{
			System.out.println(InetAddress.getLocalHost().getHostName());
		}
		catch ( UnknownHostException e )
		{
			e.printStackTrace();
		}
	}

}
