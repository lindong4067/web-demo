

package com.example.webdemo.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CachedProviderHandler implements InvocationHandler {
    private Map<String, Object> cached = new HashMap<>();
    private Object target;

    public CachedProviderHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?>[] types = method.getParameterTypes();
        if (method.getName().matches("get.+") && (types.length == 1) && (types[0] == String.class)) {
            String key = (String) args[0];
            Object value = cached.get(key);
            if (value == null) {
                value = method.invoke(target, args);
                cached.put(key, value);
            }
            return value;
        }
        return method.invoke(target, args);
    }
}
