package com.bejond.wholetest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Date;

public class Bean {

	@JsonFormat( pattern = "yyyy-MM-dd")
	private Date date;

	public Bean() {

		this.date = new Date();
	}

	public Date getDate() {

		return date;
	}

	public void setDate(Date date) {

		this.date = date;
	}

	@Override
	public String toString() {

		ObjectMapper objectMapper = new ObjectMapper();

		try
		{
			return objectMapper.writeValueAsString(this);
		}
		catch ( JsonProcessingException e )
		{
			e.printStackTrace();
		}

		return null;
	}
}
