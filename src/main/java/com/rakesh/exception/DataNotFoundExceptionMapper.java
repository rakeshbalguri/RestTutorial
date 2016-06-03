package com.rakesh.exception;

import com.rakesh.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by osboxes on 03/06/16.
 */
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {
    @Override
    public Response toResponse(DataNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(100, e.getMessage());
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .build();
    }
}
