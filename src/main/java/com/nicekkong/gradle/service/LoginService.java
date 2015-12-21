/*
 * Copyright (c) 2015.
 * nicekkong JE Foundation
 */

package com.nicekkong.gradle.service;

/**
 * Created by nicekkong on 2015. 12. 18..
 */
public class LoginService implements Login {

    private String userName;
    private String passWord;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean isAuthorized(String email, String passWord){

        if(this.userName.equals(email) && this.passWord.equals(passWord)) {
            return true;
        } else {
            return false;
        }
    }
}
