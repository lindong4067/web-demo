/*
 *         File : DemoEntity.java
 *    Classname : DemoEntity
 *    Author(s) : eznlzhi
 *      Created : 2018-02-01
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

package com.example.webdemo.validator;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
public class DemoEntity implements Serializable{

    @NotBlank
    @Length(min = 2, max = 10)
    private String name;

    @Min(value = 1, message = "年龄不能小于1.")
    private int age;

    @NotBlank
    @Email
    private String email;
}
