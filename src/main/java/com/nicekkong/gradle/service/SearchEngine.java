/*
 * Copyright (c) 2015.
 * nicekkong JE Foundation
 */

package com.nicekkong.gradle.service;

import com.nicekkong.gradle.model.Document;
import com.nicekkong.gradle.model.Type;

import java.util.List;

/**
 * Created by nicekkong on 2015. 12. 17..
 */
public interface SearchEngine {

    public List<Document> findByType(Type documentType);
    public List<Document> listAll();
    public List<Document> findByLocation(String location);
}
