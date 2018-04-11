

package com.example.webdemo.pattern.adapter._class;

public class VoltageAdapter extends Voltage220 implements Voltage5 {
    @Override
    public int outPut5V() {
        int src = outPut220V();
        System.out.println("适配器工作开始适配电压");
        int dst = src / 44;
        System.out.println("适配完成后输出电压：" + dst);
        return dst;
    }
}
