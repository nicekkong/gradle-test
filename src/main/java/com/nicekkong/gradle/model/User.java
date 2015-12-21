/*
 * 2015. 12. 21.
 * Properties of nicekkong@gmail.com
 * Copyright (c) JE Foundation
 */

package com.nicekkong.gradle.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicekkong on 2015. 12. 21..
 */
public class User {

    private String userId;
    private String email;
    private String passWord;
    private String name;

    List<Document> documents = new ArrayList<Document>();

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
