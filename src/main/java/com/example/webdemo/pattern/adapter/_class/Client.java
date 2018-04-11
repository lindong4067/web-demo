

package com.example.webdemo.pattern.adapter._class;

public class Client {
    public static void main(String[] args) {
        VoltageAdapter vo = new VoltageAdapter();
        int i = vo.outPut5V();
        System.out.println("输出电压：" + i + " V");
    }
}
