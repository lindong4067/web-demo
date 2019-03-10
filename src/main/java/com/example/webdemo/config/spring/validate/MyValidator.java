package com.example.webdemo.config.spring.validate;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Lindong Zhao
 * @create 2019-03-10 13:57
 **/
public class MyValidator {
    public void validate() {
        Foo target = new Foo();
        DataBinder binder = new DataBinder(target);
        binder.setValidator(new FooValidator());

// bind to the target object
//        binder.bind(propertyValues);

// validate the target object
        binder.validate();

// get BindingResult that includes any validation errors
        BindingResult results = binder.getBindingResult();
    }

    private class Foo {
    }

    private class FooValidator implements Validator {
        @Override
        public boolean supports(Class<?> clazz) {
            return false;
        }

        @Override
        public void validate(Object target, Errors errors) {

        }
    }
}
