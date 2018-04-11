

package com.example.webdemo.pattern.proxy;

public class FontProviderFromDesk implements FontProvider {
    @Override
    public Font getFont(String name) {
        return new Font(name);
    }
}
