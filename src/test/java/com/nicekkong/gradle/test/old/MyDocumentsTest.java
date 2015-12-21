/*
 * Copyright (c) 2015.
 * nicekkong JE Foundation
 */

package com.nicekkong.gradle.test.old;

import com.nicekkong.gradle.model.Document;
import com.nicekkong.gradle.model.Type;
import com.nicekkong.gradle.service.SearchEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by nicekkong on 2015. 12. 19..
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:mydocuments-context.xml")
public class MyDocumentsTest {

    private static final Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);

    @Autowired
    private SearchEngine engine;

    @Autowired
    private Type webType;

    @Test
    public void testUsingSpringTest() {
        log.debug("Using Spring Test fixtures : ");

        List<Document> documents = engine.findByType(webType);

        assertNotNull(documents);
        assertTrue(documents.size() == 1);
        assertEquals(webType.getName(), documents.get(0).getType().getName());
        assertEquals(webType.getExtension(), documents.get(0).getType().getExtension());
        assertEquals(webType.getDesc(), documents.get(0).getType().getDesc());

        documents = engine.listAll();
        assertNotNull(documents);
        assertTrue(documents.size() == 4);
    }
}
