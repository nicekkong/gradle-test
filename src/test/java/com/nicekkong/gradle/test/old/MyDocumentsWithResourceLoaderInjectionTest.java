/*
 * Copyright (c) 2015.
 * nicekkong JE Foundation
 */

package com.nicekkong.gradle.test.old;

import com.nicekkong.gradle.views.ResourcLoaderMenu;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

/**
 * Created by nicekkong on 2015. 12. 18..
 */
public class MyDocumentsWithResourceLoaderInjectionTest {

private static final Logger log = LoggerFactory.getLogger(MyDocumentsWithResourceLoaderInjectionTest.class);
private ClassPathXmlApplicationContext ctx;

    @Before
    public void setup() {
        System.out.println("\t\t=================Start of MyDocumentsWithResourceLoaderInjectionTest.java==========================");
        ctx = new ClassPathXmlApplicationContext("mydocuments-resourceloader-injection-context.xml");
    }

    @Test
    public void testMenu() {
        log.debug("Calling the Menu as ResourceLoader Injection : ");
        ResourcLoaderMenu menu = ctx.getBean(ResourcLoaderMenu.class);
        assertNotNull(menu);
        menu.printMenu("classpath:menu.txt");
        System.out.println("\t\t=================End of MyDocumentsWithResourceLoaderInjectionTest.java==========================");
    }
}