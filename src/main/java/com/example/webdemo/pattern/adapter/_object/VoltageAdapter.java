

package com.example.webdemo.pattern.adapter._object;

import com.example.webdemo.pattern.adapter._class.Voltage220;
import com.example.webdemo.pattern.adapter._class.Voltage5;

public class VoltageAdapter implements Voltage5 {
    private Voltage220 voltage220;

    public VoltageAdapter(Voltage220 voltage220) {
        this.voltage220 = voltage220;
    }

    @Override
    public int outPut5V() {
        int V5 = 0;
        if (voltage220 != null) {
            int V220 = voltage220.outPut220V();
            V5 = V220 / 44;
        }
        return V5;
    }

    public static void main(String[] args) {
        VoltageAdapter volt = new VoltageAdapter(new Voltage220());
        int put5V = volt.outPut5V();
        System.out.println("输出电压: " + put5V + "V");
    }
}
