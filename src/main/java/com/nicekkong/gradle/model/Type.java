/*
 * Copyright (c) 2015.
 * nicekkong JE Foundation
 */

package com.nicekkong.gradle.model;

/**
 * Created by nicekkong on 2015. 12. 16..
 */
public class Type {

    private String typeId;
    private String name;
    private String desc;
    private String extension;

    public Type() {
    }

    public Type(String name, String extension) {
        this.extension = extension;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("Type{");
        builder.append("id: " + typeId);
        builder.append("name : " + name);
        builder.append("desc : " + desc);
        builder.append("extension: " + extension);
        builder.append("}");

        return builder.toString();
    }
}
