

package com.example.webdemo.pattern.proxy;

public abstract class ProviderFactory {
    public static FontProvider getFontProvider() {
        return new FontProviderFromDesk();
    }

    public static FontProvider getCachedFontProvider() {
        return new CachedFontProvider(new FontProviderFromDesk());
    }
}
