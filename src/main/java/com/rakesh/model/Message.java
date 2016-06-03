package com.rakesh.model;

import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

/**
 * Created by osboxes on 03/06/16.
 */
@XmlRootElement
public class Message {


    private long id;
    private String message;
    private Date dateCreated;
    private String author;
    private List<Links> links;


    public Message() {
    }

    public Message(long id, String message, Date dateCreated, String author, List<Links> links) {
        this.id = id;
        this.message = message;
        this.dateCreated = dateCreated;
        this.author = author;
        this.links = links;
    }

    public List<Links> getLinks() {
        return links;
    }

    public void setLinks(List<Links> links) {
        this.links = links;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", dateCreated=" + dateCreated +
                ", author='" + author + '\'' +
                '}';
    }
}
