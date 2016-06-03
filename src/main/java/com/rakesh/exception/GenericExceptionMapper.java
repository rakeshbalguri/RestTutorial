package com.rakesh.exception;


import com.rakesh.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * Created by osboxes on 03/06/16.
 */
@Provider
public class GenericExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<Throwable>{
    @Override
    public Response toResponse(Throwable throwable) {
        ErrorMessage errorMessage = new ErrorMessage(100, throwable.getMessage());
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .build();
    }
}
