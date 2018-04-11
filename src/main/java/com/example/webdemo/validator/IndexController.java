

package com.example.webdemo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@RestController
public class IndexController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/validator")
//    @Validated 是 @Valid 的包装类
    public String validator(@Validated @RequestBody DemoEntity demoEntity, BindingResult result){
        if(result.hasErrors()){
            StringBuffer msg = new StringBuffer();
            List<FieldError> fieldErrors = result.getFieldErrors();
            Locale locale = LocaleContextHolder.getLocale();
            for (FieldError fieldError : fieldErrors) {
                String message = messageSource.getMessage(fieldError, locale);
                msg.append(fieldError.getField() + ":" + message + "\n");
            }
            return msg.toString();
        }
        return "验证通过！ 姓名：" + demoEntity.getName() + "，年龄：" + demoEntity.getAge() + "，邮箱：" + demoEntity.getEmail();
    }
}
