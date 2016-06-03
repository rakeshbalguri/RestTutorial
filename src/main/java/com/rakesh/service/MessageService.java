package com.rakesh.service;

import com.rakesh.database.DatabaseClass;
import com.rakesh.exception.DataNotFoundException;
import com.rakesh.model.Links;
import com.rakesh.model.Message;
import com.sun.research.ws.wadl.Link;

import java.util.*;

/**
 * Created by osboxes on 03/06/16.
 */
public class MessageService {

    private Map<Long, Message> messageMap = DatabaseClass.getMessages();

    public MessageService() {
        Links link = new Links("/messages", "self");
        List<Links> links = new ArrayList<>();
        links.add(link);
        Message one = new Message(1, "First", new Date(), "ABCD", links);
        Message two = new Message(2, "Second", new Date(), "XYZ", links);
        Message three = new Message(3, "Three", new Date(), "QWE", links);

        messageMap.put(1L, one);
        messageMap.put(2L, two);
        messageMap.put(3L, three);

    }

    public List<Message> getAllMessages() {
        return new ArrayList<>(messageMap.values());
    }

    public List<Message> getAllMessagesForYear(int year) {
        Calendar cal = Calendar.getInstance();
        List<Message> messages = new ArrayList<Message>();
        for (Message message : messageMap.values()) {
            cal.setTime(message.getDateCreated());
            if (cal.get(Calendar.YEAR) == year) {
                messages.add(message);
            }
        }

        return messages;
    }

    public List<Message> getAllMessagesForRange(int start, int size) {
        List<Message> messages = new ArrayList<Message>(messageMap.values());
        if(start+size > messages.size()) return  new ArrayList<Message>();
        return messages.subList(start, start+size);

    }


    public Message getMessage(Long id) {
        final Message message = messageMap.get(id);
        if(message == null)
        {
            throw new DataNotFoundException("No Message found with the id "+id);
        }

        return message;
    }

    public Message addMessage(Message message) {
        message.setId(messageMap.size() + 1);
        messageMap.put(message.getId(), message);
        return message;
    }

    public Message deleteMessage(Long id) {
        return messageMap.remove(id);
    }

    public Message updateMessage(Message message) {
        if (message.getId() <= 0) {
            return null;
        }

        messageMap.put(message.getId(), message);
        return message;
    }
}
