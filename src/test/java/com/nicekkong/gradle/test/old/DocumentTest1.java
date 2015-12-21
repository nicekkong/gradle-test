/*
 * Copyright (c) 2015.
 * nicekkong JE Foundation
 */

package com.nicekkong.gradle.test.old;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by nicekkong on 2015. 12. 16..
 */
public class DocumentTest1 {

    private static int num = 0;

    @Before
    public void init() {

        num ++ ;
        System.out.println("=======> init() num :" + num);
    }

    @Test
    public void test1() {

        String str = "Test1";

        assertNotNull(str);
        assertEquals("Test1", str);

    }

    @Test
    public void test2() {

        String str = "Test String";

        assertNotNull(str);
        assertNotEquals("Test", str);

    }

    @Test
    public void testGetName() throws Exception {

    }

    @Test
    public void testSetName() throws Exception {

    }

    @Test
    public void testGetPageNum() throws Exception {

    }

    @Test
    public void testSetPageNum() throws Exception {

    }

    @Test
    public void testGetAuthor() throws Exception {

    }

    @Test
    public void testSetAuthor() throws Exception {

    }
}
