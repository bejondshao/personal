package com.bejond.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Created by Bejond on 2016/8/9.
 */
@Path("/print")
public class PrintMessageRestService {

	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String message) {

		String result = "Restful example: " + message;

		return Response.status(200).entity(result).build();
	}
}
