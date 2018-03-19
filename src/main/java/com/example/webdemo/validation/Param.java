/*
 *         File : Param.java
 *    Classname : Param
 *    Author(s) : eznlzhi
 *      Created : 2018-01-31
 *
 * Copyright (c) 2017 Ericsson AB, Sweden.
 * All rights reserved.
 * The Copyright to the computer program(s) herein is the property of
 * Ericsson AB, Sweden.
 * The program(s) may be used and/or copied with the written permission
 * from Ericsson AB or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s)
 * have been supplied.
 *
 */

package com.example.webdemo.validation;

import java.lang.annotation.Annotation;

public class Param {
    private String simpleName;
    private String name;
    private Class<?> type;
    private Object value;
    private Annotation anno;

    public Param() {
    }

    public Param(String simpleName, String name, Class<?> type, Object value, Annotation anno) {
        this.simpleName = simpleName;
        this.name = name;
        this.type = type;
        this.value = value;
        this.anno = anno;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Annotation getAnno() {
        return anno;
    }

    public void setAnno(Annotation anno) {
        this.anno = anno;
    }

    @Override
    public String toString() {
        return "Param{" +
                "simpleName='" + simpleName + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", value=" + value +
                ", anno=" + anno +
                '}';
    }
}
