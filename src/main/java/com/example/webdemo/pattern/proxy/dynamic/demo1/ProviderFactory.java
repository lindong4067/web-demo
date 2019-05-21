package com.example.webdemo.pattern.proxy.dynamic.demo1;

import com.example.webdemo.pattern.proxy.FontProvider;
import com.example.webdemo.pattern.proxy.FontProviderFromDesk;

import java.lang.reflect.Proxy;

public abstract class ProviderFactory {
    public static FontProvider getFontProvider() {
        return new FontProviderFromDesk();
    }

    public static ImageProvider getImageProvider() {
        return new ImageProviderFromDesk();
    }

    public static MusicProvider getCachedMusicProvider() {
        return new MusicProviderFromDesk();
    }

    public static FontProvider getDynamicFontProvider() {
        Class<FontProvider> aClass = FontProvider.class;
        /*
         * Object invoke(Object proxy, Method method, Object[] args) throws Throwable
         * proxy:　　指代我们所代理的那个真实对象
         * method:　　指代的是我们所要调用真实对象的某个方法的Method对象
         * args:　　指代的是调用真实对象某个方法时接受的参数
         */

        /**
         * public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) throws IllegalArgumentException
         * loader:　　一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
         * interfaces:　　一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
         * h:　　一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上
         */
        return (FontProvider) Proxy.newProxyInstance(aClass.getClassLoader(),
                new Class[]{aClass},
                new CachedProviderHandler(new FontProviderFromDesk()));
    }
}
