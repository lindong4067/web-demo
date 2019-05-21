

package com.example.webdemo.pattern.proxy.dynamic.demo1;

public class ImageProviderFromDesk implements ImageProvider {
    @Override
    public Image getImage(String name) {
        return new Image(name);
    }
}
