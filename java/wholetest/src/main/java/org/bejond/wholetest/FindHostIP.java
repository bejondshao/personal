package org.bejond.wholetest;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class FindHostIP {

	public static void main(String a[]){

		try {
			InetAddress[] myHost = InetAddress.getAllByName("cambridge-ap.shijicloud.com");
			for(InetAddress host:myHost){
				System.out.println(host.getHostAddress());
			}
		} catch (UnknownHostException ex) {
			ex.printStackTrace();
		}
	}
}
