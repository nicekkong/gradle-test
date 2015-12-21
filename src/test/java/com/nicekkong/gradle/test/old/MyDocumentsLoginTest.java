/*
 * Copyright (c) 2015.
 * nicekkong JE Foundation
 */

package com.nicekkong.gradle.test.old;


import com.nicekkong.gradle.service.Login;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

/**
 * Created by nicekkong on 2015. 12. 19..
 */
public class MyDocumentsLoginTest {

    private static final Logger log = LoggerFactory.getLogger(MyDocumentsLoginTest.class);

    private static final String EMAIL = "nicekkong@gmail.com";
    private static final String PASSWORD = "qwer";
    private static final String SUCCESS = "This is authorized account.";
    private static final String FAILURE = "WARNING~!! Not authorized account.";

    private ClassPathXmlApplicationContext ctx;

    @Before
    public void setup() {
        ctx = new ClassPathXmlApplicationContext("mydocuments-login-context.xml");
    }

    @Test
    public void testLogin() {
        log.debug("Login Test");
        Login login = ctx.getBean(Login.class);

        assertNotNull(login);
        if(login.isAuthorized(EMAIL, PASSWORD)) {
            System.out.println(SUCCESS);
        } else {
            System.out.println(FAILURE);
        }

    }
}
