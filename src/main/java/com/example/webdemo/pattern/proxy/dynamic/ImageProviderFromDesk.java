

package com.example.webdemo.pattern.proxy.dynamic;

public class ImageProviderFromDesk implements ImageProvider {
    @Override
    public Image getImage(String name) {
        return new Image(name);
    }
}
