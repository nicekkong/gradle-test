/*
 * Copyright (c) 2015.
 * nicekkong JE Foundation
 */

package com.nicekkong.gradle.test.old;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


/**
 * Created by nicekkong on 2015. 12. 17..
 */
public class MyDocumentTest2 {

    private static final Logger log = LoggerFactory.getLogger(MyDocumentTest2.class);
    private ClassPathXmlApplicationContext ctx;

    @Before
    public void setup() {
        System.out.println("=================Start of MyDocumentTest2.java==========================");
        ctx = new ClassPathXmlApplicationContext("mydocuments-context.xml");
    }

    @Test
    public void testMenu() {

        log.debug("About to read the Resource file : menu.txt");
        Resource resource = ctx.getResource("classpath:menu.txt");

        try {
            InputStream stream = resource.getInputStream();
            Scanner scanner = new Scanner(stream);
            while(scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void end() {
        System.out.println("=================End of MyDocumentTest2.java==========================");
    }
}
