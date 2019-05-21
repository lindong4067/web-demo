

package com.example.webdemo.pattern.proxy.dynamic.demo1;

import com.example.webdemo.pattern.proxy.Font;
import com.example.webdemo.pattern.proxy.FontProvider;

public class Client2 {
    public static void main(String[] args) {
        FontProvider dynamicFontProvider = ProviderFactory.getDynamicFontProvider();
        Font font = dynamicFontProvider.getFont("微软雅黑");
        System.out.println(font.getName());

    }
}
