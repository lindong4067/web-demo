

package com.example.webdemo.frame.loader;

//import org.junit.Test;

public class ClassLoaderDemo {
//    @Test
    public void main() {
        //获取当前线程的Class Loader
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //获取当前类的Class Loader
        ClassLoader classLoader1 = this.getClass().getClassLoader();
        //获取系统的Class Loader
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();//使用系统ClassLoader

        System.out.println(classLoader.toString());
        System.out.println(classLoader1.toString());
        System.out.println(systemClassLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
    }
}
