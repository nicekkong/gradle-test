/*
 * Copyright (c) 2015.
 * nicekkong JE Foundation
 */

package com.nicekkong.gradle.data;

import com.nicekkong.gradle.model.Document;

import java.util.List;

/**
 * Created by nicekkong on 2015. 12. 16..
 */
public interface DocumentDAO {
    public List<Document> getAll();
}