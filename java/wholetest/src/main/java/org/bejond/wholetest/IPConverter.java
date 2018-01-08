package org.bejond.wholetest;

import org.apache.commons.net.util.SubnetUtils;
import sun.net.util.IPAddressUtil;

public class IPConverter {

	public int intOfIpV4(String ip) {
		int result = 0;
		byte[] bytes = IPAddressUtil.textToNumericFormatV4(ip);
		if (bytes == null) {
			return result;
		}
		for (byte b : bytes) {
			result = result << 8 | (b & 0xFF);
		}
		return result;
	}

	public boolean inRange(String range, String ip) {
		SubnetUtils utils = new SubnetUtils(range);
		boolean inRange = utils.getInfo().isInRange(ip);
		System.out.println(inRange);
		return inRange;
	}

	public static void main(String [] args) {

		IPConverter ipConverter = new IPConverter();
		System.out.println(ipConverter.intOfIpV4("23.168.1.13"));
		ipConverter.inRange("192.168.1.0/24", "192.168.1.2");
	}
}
