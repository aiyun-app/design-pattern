package com.rainier.proxypattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GalaxyMall implements InvocationHandler {

    private Object obj;

    public GalaxyMall(){

    }

    public Object getProxy(Object obj){
        this.obj = obj;
        Class<?> clazz = this.obj.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("高清无码视频展示，支持银河系语言，模特美丽动人");

        Object obj = method.invoke(this.obj, args);

        System.out.println("快递到家，不满意不用退货、不要钱");
        return obj;
    }
}
