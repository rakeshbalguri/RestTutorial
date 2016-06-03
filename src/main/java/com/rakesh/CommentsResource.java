package com.rakesh;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by osboxes on 03/06/16.
 */
@Path("/")
public class CommentsResource {

    @GET
    public String getComments()
    {
        return "Comments";
    }

    @GET
    @Path("/{commentId}")
    public String getComments(@PathParam("messageId") String messageId , @PathParam("commentId") String commentId )
    {
        return "Comments :"+messageId +commentId;
    }
}
