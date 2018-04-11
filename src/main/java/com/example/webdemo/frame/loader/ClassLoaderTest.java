

package com.example.webdemo.frame.loader;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                log.info("L-28-name: {}", name);
                try{
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    log.info("L-35-fileName: {}", fileName);
                    InputStream is = getClass().getResourceAsStream(fileName);
                    log.info("L-39-is: {}", is);
                    if(is == null){
                        log.info("is null: ");
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    log.info("L-43-b: {}", b);
                    int read = is.read(b);
                    log.info("L-45-b: {}", b);
                    log.info("L-46-b: {}", read);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e){
                    throw new ClassNotFoundException();
                }
            }
        };

        // 使用ClassLoaderTest的类加载器加载本类
        Object obj1 = ClassLoaderTest.class.getClassLoader().loadClass("com.example.webdemo.frame.loader.ClassLoaderTest").newInstance();
        System.out.println(obj1.getClass());
        System.out.println(obj1 instanceof ClassLoaderTest);

        // 使用自定义类加载器加载本类
        Object obj2 = myLoader.loadClass("com.example.webdemo.frame.loader.ClassLoaderTest").newInstance();
        System.out.println(obj2.getClass());
        System.out.println(obj2 instanceof ClassLoaderTest);
    }
}
