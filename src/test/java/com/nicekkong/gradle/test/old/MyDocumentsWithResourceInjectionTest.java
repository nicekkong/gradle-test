/*
 * Copyright (c) 2015.
 * nicekkong JE Foundation
 */

package com.nicekkong.gradle.test.old;

import com.nicekkong.gradle.views.Menu;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

/**
 * Created by nicekkong on 2015. 12. 17..
 */
public class MyDocumentsWithResourceInjectionTest {

    private static final Logger log = LoggerFactory.getLogger(MyDocumentsWithResourceInjectionTest.class);
    private ClassPathXmlApplicationContext ctx;

    @Before
    public void setup() {
        System.out.println("\t\t=================Start of MyDocumentsWithResourceInjectionTest.java==========================");
        ctx = new ClassPathXmlApplicationContext("mydocuments-context.xml");
    }

    @Test
    public void testMenu() {
        log.debug("Calling the Menu as Resource Injection : ");
        Menu menu = ctx.getBean(Menu.class);
        assertNotNull(menu);
        menu.printMenu();
        System.out.println("\t\t=================End of MyDocumentsWithResourceInjectionTest.java==========================");
    }
}
