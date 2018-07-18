package org.bejond.wholetest;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

	private Date convertString2Date(String expiry) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
		//expiry = expiry.substring(0, 3) + "20" + expiry.substring(3); // doesn't need to do this

		try
		{
			return simpleDateFormat.parse(expiry);
		}
		catch ( ParseException e )
		{
			e.printStackTrace();
		}

		return null;
	}

	@Test
	public void testConvertString2Date() {
		String expiry = "12/28";
		System.out.println(convertString2Date(expiry));
	}
}
