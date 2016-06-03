package com.rakesh;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * Created by osboxes on 03/06/16.
 */

@Path("/inject")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

    @GET
    @Path("annotations")
    public String getUsingAnnotation(@MatrixParam("param") String matrixParam)
    {
        return "Test MEssage"+matrixParam;
    }

    @GET
    @Path("header")
    public String getHeaderInfo(@HeaderParam("header1") String headerParam)
    {
        return "Test MEssage"+headerParam;
    }

    @GET
    @Path("context")
    public String getContextInfo(@Context UriInfo uriInfo, @Context HttpHeaders headers)
    {
        return "Test Message: "+uriInfo + "\n Headers "+headers;
    }

}
