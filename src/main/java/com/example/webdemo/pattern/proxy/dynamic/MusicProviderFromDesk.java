

package com.example.webdemo.pattern.proxy.dynamic;

public class MusicProviderFromDesk implements MusicProvider {
    @Override
    public Music getMusic(String name) {
        return new Music(name);
    }
}
