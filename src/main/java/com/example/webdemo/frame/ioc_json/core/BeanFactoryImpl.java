package com.example.webdemo.frame.ioc_json.core;

import com.example.webdemo.frame.ioc_json.bean.BeanDefinition;
import com.example.webdemo.frame.ioc_json.bean.ConstructorArg;
import com.example.webdemo.frame.ioc_json.utils.BeanUtils;
import com.example.webdemo.frame.ioc_json.utils.ClassUtils;
import com.example.webdemo.frame.ioc_json.utils.ReflectionUtils;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactoryImpl implements BeanFactory {

    private static final ConcurrentHashMap<String, Object> beanMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    private static final Set<String> beanNameSet = Collections.synchronizedSet(new HashSet<>());

    @Override
    public Object getBean(String name) throws Exception {
        Object bean = beanMap.get(name);
        if (bean != null) {
            return bean;
        }
        bean = createBean(beanDefinitionMap.get(name));
        if (bean != null) {
            populateBean(bean);
            beanMap.put(name, bean);
        }
        return bean;
    }

    private void populateBean(Object bean) throws Exception {
        Field[] fields = bean.getClass().getSuperclass().getDeclaredFields();
        if (fields != null && fields.length > 0) {
            for (Field field : fields) {
                String beanName = field.getName();
                beanName = StringUtils.uncapitalize(beanName);
                if (beanNameSet.contains(field.getName())) {
                    Object fieldBean = getBean(beanName);
                    if (fieldBean != null) {
                        ReflectionUtils.injectField(field, bean, fieldBean);
                    }
                }
            }
        }
    }

    private Object createBean(BeanDefinition beanDefinition) throws Exception {
        String beanClassName = beanDefinition.getClassName();
        Class clz = ClassUtils.loadClass(beanClassName);
        if (clz == null) {
            throw new Exception("can not find bean by beanClassName : " + beanClassName);
        }
        List<ConstructorArg> constructorArgs = beanDefinition.getConstructorArgs();
        if (constructorArgs != null && !constructorArgs.isEmpty()) {
            List<Object> objects = new ArrayList<>();
            for (ConstructorArg constructorArg : constructorArgs) {
                objects.add(getBean(constructorArg.getRef()));
            }
            return BeanUtils.instanceByCglib(clz, clz.getConstructor(), objects.toArray());
        } else {
            return BeanUtils.instanceByCglib(clz, null, null);
        }
    }

    public void registerBean(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
        beanNameSet.add(name);
    }
}
