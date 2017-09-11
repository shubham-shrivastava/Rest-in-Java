package org.shubham.wingify.store.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.shubham.wingify.store.model.ErrorMessage;

@Provider
public class DataNotfoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "http://heregoeshelplink.com");
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}
	
}
