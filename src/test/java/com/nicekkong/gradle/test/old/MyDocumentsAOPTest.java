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
@ContextConfiguration("classpath:mydocuments-aop-context.xml")
public class MyDocumentsAOPTest {

    private static final Logger log = LoggerFactory.getLogger(MyDocumentsAOPTest.class);

    @Autowired
    private SearchEngine afterEngineProxy;
    @Autowired
    private SearchEngine beforeEngineProxy;
    @Autowired
    private SearchEngine aroundEngineProxy;
    @Autowired
    private SearchEngine cachingEngineProxy;
    @Autowired
    private Type webType;

    @Test
    public void testUsingSpringAOP() {
        log.debug("Using Spring AOP");

        List<Document> documents = afterEngineProxy.findByType(webType);
        assertNotNull(documents);
        assertTrue(documents.size() == 1);
        assertEquals(webType.getName(), documents.get(0).getType().getName());
        assertEquals(webType.getDesc(), documents.get(0).getType().getDesc());
        assertEquals(webType.getExtension(), documents.get(0).getType().getExtension());

        documents = beforeEngineProxy.listAll();
        assertNotNull(documents);
        assertTrue(documents.size() == 4);

        try {
            aroundEngineProxy.findByLocation("/some/path/");
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

    @Test
    public void testUsingSpringAOPCaching() {
        log.debug("Testing Caching Module....");

        List<Document> documents = cachingEngineProxy.findByType(webType);
        assertNotNull(documents);

        int count = documents.size();

        log.debug("It should be now cached~!!!");

        log.debug("@@@@@@@");
        log.debug("@@@@@5@@@@@" + String.valueOf(cachingEngineProxy.findByType(webType)));

        documents = cachingEngineProxy.findByType(webType);
        assertNotNull(documents);
        assertEquals(count, documents.size());

        log.debug("It should be now cached~!!");
        documents = cachingEngineProxy.findByType(webType);
        assertNotNull(documents);
        assertEquals(count, documents.size());
    }
}
