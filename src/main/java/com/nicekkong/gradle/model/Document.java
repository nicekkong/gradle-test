/*
 * Copyright (c) 2015.
 * nicekkong JE Foundation
 */

package com.nicekkong.gradle.model;

import java.util.Date;

/**
 * Created by nicekkong on 2015. 12. 16..
 */
public class Document {

    private String documentId;
    private String name;
    private Type type;
    private String location;
    private String description;
    private Date created;
    private Date modified;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String toString() {

        StringBuffer builder = new StringBuffer("Documents(");

        builder.append("id : " + documentId);
        builder.append("name : " + name);
        builder.append(", type : " + type);
        builder.append(", location : " + location);
        builder.append(")");

        return builder.toString();
    }
}
