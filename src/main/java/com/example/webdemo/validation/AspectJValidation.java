

package com.example.webdemo.validation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

@Aspect
@Component
public class AspectJValidation {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("@annotation(com.example.webdemo.validation.Validate)")
    public void validateCut(){

    }

    @Around("validateCut()")
    public Object validate(ProceedingJoinPoint point) throws Throwable {
        logger.info("Start intercept parameter ! ");
        Object[] args = point.getArgs();
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        boolean flag = validateParameterAnnotation(parameterAnnotations);
        if(!flag){
            //我觉得这里不需要传入 args
            return point.proceed();
        }
        List<Param> params = AnnotationHelper.getParams(method, args);
        if(params.size() != 0){
            for (Param param : params) {
                String validRes = validateDetail(param);
                if(validRes != null){
                    logger.info("Param validation error message:{}", validRes);
                    return new ResponseEntity<>("Param validation error.", HttpStatus.BAD_REQUEST);
                }
            }
        }
        //我觉得这里不需要传入 args
        return point.proceed();
    }

    private String validateDetail(Param param) throws IllegalAccessException {
        Validate validate = (Validate) param.getAnno();
        boolean b = validate.isValidate();
        StringBuilder sb = new StringBuilder();
        if(b){
            if(validate.isForm()){
                String res = validateForm(param);
                append(sb, res);
            }else{
                String res = validateCommon(param);
                append(sb, res);
            }
        }
        return sb.toString();
    }

    private void append(StringBuilder sb, String res) {
        if(res != null){
            sb.append("-");
            sb.append(res);
        }
    }

    private String validateCommon(Param param) {
        String res = null;
        if(param.getValue() == null){
            res = param.getName() + " param value is null.";
        }
        return res;
    }

    private String validateForm(Param param) throws IllegalAccessException {
        Class<?> clazz = param.getValue().getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        for (Field field : declaredFields) {
            Annotation[] annotations = field.getAnnotations();
            if(annotations.length != 0){
                String paramName = param.getName() + "." + field.getName();
                Must must = (Must)annotations[0];
                if(must.isMust()){
                    field.setAccessible(true);
                    Object object = field.get(param.getValue());
                    Class<?> type = field.getType();
                    if(type.isArray()){
                        Object[] arr = (Object[]) object;
                        if(arr.length == 0){
                            append(sb, paramName + "Can't be null.");
                        }
                    }else if(type.isPrimitive()){
                        if(type == int.class){
                            int intObj = (int) object;
                            if(intObj <= 0){
                                append(sb, paramName + "Can't less than 0.");
                            }
                        }else if(type == long.class){
                            long longObj = (long) object;
                            if(longObj <= 0){
                                append(sb, paramName + "Can't less than 0");
                            }
                        }
                    }else if(type == String.class){
                        if(object == null){
                            append(sb, paramName + "Can't be null.");
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    private boolean validateParameterAnnotation(Annotation[][] parameterAnnotations) {
        boolean flag = false;
        for (Annotation[] parameterAnnotation : parameterAnnotations) {
            for (Annotation annotation : parameterAnnotation) {
                if(annotation.annotationType() == Validate.class){
                    flag = true;
                }
            }
        }
        return flag;
    }
}
