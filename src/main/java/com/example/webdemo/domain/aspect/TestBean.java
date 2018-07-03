

package com.example.webdemo.domain.aspect;

public class TestBean {

    private String testStr = "TestString~~~";

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public void test() {
        System.out.println("Test~~~");
    }
}
