/*
 * Copyright (c) 2015.
 * nicekkong JE Foundation
 */

package com.nicekkong.gradle.data;

import com.nicekkong.gradle.model.Type;

/**
 * Created by nicekkong on 2015. 12. 16..
 */
public interface TypeDataDao {

    public Type[] getAll();
    public Type findById(String id);
}
