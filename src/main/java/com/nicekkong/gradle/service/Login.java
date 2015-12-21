/*
 * Copyright (c) 2015.
 * nicekkong JE Foundation
 */

package com.nicekkong.gradle.service;

/**
 * Created by nicekkong on 2015. 12. 18..
 */
public interface Login {
    public boolean isAuthorized(String email, String pass);
}