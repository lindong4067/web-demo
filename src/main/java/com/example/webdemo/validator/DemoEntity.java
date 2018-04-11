

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
