

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
