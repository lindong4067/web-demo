

package com.example.webdemo.frame.aop.advisor;

import com.example.webdemo.frame.aop.interceptor.AopMethodInterceptor;

import java.util.LinkedList;
import java.util.List;

public class AdvisedSupport extends Advisor{
    private TargetSource targetSource;
    private List<AopMethodInterceptor> list = new LinkedList<>();
    public void addAopMethodInterceptor(AopMethodInterceptor interceptor){
        list.add(interceptor);
    }
    public void addAopMethodInterceptors(List<AopMethodInterceptor> interceptors){
        list.addAll(interceptors);
    }
}
