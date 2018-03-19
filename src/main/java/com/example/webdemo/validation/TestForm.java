/*
 *         File : TestForm.java
 *    Classname : TestForm
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

import java.io.Serializable;

public class TestForm implements Serializable {
    @Must
    private int age;

    @Must
    private String[] pics;

    @Must
    private long goodsIds;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getPics() {
        return pics;
    }

    public void setPics(String[] pics) {
        this.pics = pics;
    }

    public long getGoodsIds() {
        return goodsIds;
    }

    public void setGoodsIds(long goodsIds) {
        this.goodsIds = goodsIds;
    }
}
