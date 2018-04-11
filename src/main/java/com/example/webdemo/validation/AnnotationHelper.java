

package com.example.webdemo.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AnnotationHelper {

    public static List<Param> getParams(Method method, Object[] args) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        Class<?>[] parameterTypes = method.getParameterTypes();
        List<Param> params = new ArrayList<>();
        for(int i=0;i<parameterAnnotations.length;i++){
            for(int j=0;j<parameterAnnotations[i].length;j++){
                //如果出现指定的注解类型
                if(parameterAnnotations[i][j].annotationType() == Validate.class){
                    Param param = new Param(parameterTypes[i].getSimpleName(),
                            parameterTypes[i].getName(),//名称
                            parameterTypes[i],//参数类型
                            args[i],//参数值
                            parameterAnnotations[i][j]);//筛选出的注解
                    params.add(param);
                }
            }
        }
        return params;
    }
}
