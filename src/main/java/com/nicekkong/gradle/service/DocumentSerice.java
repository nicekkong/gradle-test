/*
 * Copyright (c) 2015.
 * nicekkong JE Foundation
 */

package com.nicekkong.gradle.service;


import com.nicekkong.gradle.data.DocumentRepository;

import java.util.List;

/**
 * Created by nicekkong on 2015. 12. 16..
 */
public interface DocumentSerice {

    public List<String> readDoc(DocumentRepository doc);
}
