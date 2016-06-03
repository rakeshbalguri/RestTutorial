package com.rakesh;

import com.rakesh.model.Message;
import com.rakesh.model.MessageQueryParams;
import com.rakesh.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

/**
 * Created by osboxes on 03/06/16.
 */


@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

    private MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessages(@BeanParam MessageQueryParams queryParams)
    {
        if(queryParams.getYear() >0)
        {
            return messageService.getAllMessagesForYear(queryParams.getYear());
        }
        if(queryParams.getStart() >=0 && queryParams.getSize() >0)
        {
            return messageService.getAllMessagesForRange(queryParams.getStart(),queryParams.getSize());
        }
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long messageId)
    {
        return messageService.getMessage(messageId);
    }

    @POST
    public Response addMessage(Message message, @Context UriInfo uriInfo)
    {
        final Message newMessage = messageService.addMessage(message);
        String newId = String.valueOf(newMessage.getId());
        URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
        return Response.created(uri)
                       .entity(newMessage)
                       .build();
//        return messageService.addMessage(message);
    }

    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long messageId,Message message)
    {
        message.setId(messageId);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") long messageId)
    {
        messageService.deleteMessage(messageId);
    }

    @Path("/{messageId}/comments")
    public CommentsResource getComment()
    {
        return new CommentsResource();
    }
}
