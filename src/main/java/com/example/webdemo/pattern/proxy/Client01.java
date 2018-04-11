

package com.example.webdemo.pattern.proxy;

import static com.example.webdemo.pattern.proxy.ProviderFactory.*;

public class Client01 {
    public static void main(String[] args) {
        FontProvider fontProvider = getFontProvider();
        Font font = fontProvider.getFont("微软雅黑");
        String fontName = font.getName();
        System.out.println(fontName);

        FontProvider cachedFontProvider = getCachedFontProvider();
        Font font1 = cachedFontProvider.getFont("微软雅黑");
        String font1Name = font1.getName();
        System.out.println(font1Name);
    }
}
