package com.example.webdemo.interceptor;

public enum CallSource {
    WEB,
    PC,
    WECHAT,
    IOS,
    ANDROID;

    public static boolean isValid(String name) {
        for (CallSource callSource : CallSource.values()) {
            if (callSource.name().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
