/*
 * Copyright (c) 2015.
 * nicekkong JE Foundation
 */

package com.nicekkong.gradle.data;

import com.nicekkong.gradle.model.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by nicekkong on 2015. 12. 16..
 */
public class TypeDataRepository implements TypeDataDao {


    private Map<String, Type> types = null;

    @Override
    public Type[] getAll() {
        return types.values().toArray(new Type[types.values().size()]);
    }

    @Override
    public Type findById(String id) {

        Type type = types.get(id);

        return type;
    }

    public Map<String, Type> getTypes() {
        return types;
    }

    public void setTypes(Map<String, Type> types) {
        this.types = types;
    }
}
