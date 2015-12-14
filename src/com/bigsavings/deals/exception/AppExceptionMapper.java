package com.bigsavings.deals.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;


public abstract class AppExceptionMapper implements ExceptionMapper<AppException> {
	 
	public Response toResponse(AppException ex) {
		return Response.status(ex.getStatus())
				.entity(new ErrorMessage(ex))
				.type(MediaType.APPLICATION_JSON).
				build();
	}
 
}
