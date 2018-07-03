

package com.example.webdemo.validator;


import javax.validation.constraints.Min;
import java.io.Serializable;


public class DemoEntity implements Serializable {

//    @Length(min = 2, max = 10)

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String name;

    @Min(value = 1, message = "年龄不能小于1.")
    private int age;

    private String email;
}
