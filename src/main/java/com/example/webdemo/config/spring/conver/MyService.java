package com.example.webdemo.config.spring.conver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lindong Zhao
 * @create 2019-03-10 11:36
 **/
@Service
public class MyService {
    private final ConversionService conversionService;

    @Autowired
    public MyService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    /**
     * Integer to String
     */
    public void doIt() {
        this.conversionService.convert(123, String.class);
    }

    /**
     * List<Integer> to List<String>
     */
    public void doThem() {
        DefaultConversionService cs = new DefaultConversionService();
        List<Integer> input = new ArrayList<>();
        cs.convert(input,
                TypeDescriptor.forObject(input),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(String.class)));

    }

}
