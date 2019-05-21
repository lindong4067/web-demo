

package com.example.webdemo.pattern.proxy.dynamic.demo1;

public class MusicProviderFromDesk implements MusicProvider {
    @Override
    public Music getMusic(String name) {
        return new Music(name);
    }
}
