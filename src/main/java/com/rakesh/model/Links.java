package com.rakesh.model;

/**
 * Created by osboxes on 03/06/16.
 */
public class Links {

    private String link;
    private String relation;

    public Links(String link, String relation) {
        this.link = link;
        this.relation = relation;
    }

    public Links() {
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
