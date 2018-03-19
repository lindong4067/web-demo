/*
 *         File : User.java
 *    Classname : User
 *    Author(s) : eznlzhi
 *      Created : 2018-01-16
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

package com.example.webdemo.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.validation.constraints.NotNull;

@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class User {
    @SerializedName("name-me")
    @NotNull(message = "Name not be null.")
    private String name;
    @SerializedName("age-me")
    @NotNull(message = "Age not be null.")
    private Integer age;
    @SerializedName("gender-me")
    private Boolean gender;
    @SerializedName("address-me")
    private Address address;
    @Expose
    private String password;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", address=" + address +
                ", password='" + password + '\'' +
                '}';
    }
}
