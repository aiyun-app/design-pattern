package com.rainier.proxypattern.dynamicproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


public class UniverseMall implements MethodInterceptor {

    public UniverseMall(){

    }

    public Object getProxy(Class<?> clazz){

        //1.工具类
        Enhancer enhancer = new Enhancer();
        //2.设置父类
        enhancer.setSuperclass(clazz);
        //3.设置回调函数
        enhancer.setCallback(this);
        //4.创建子类(代理对象)
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("VR、AR演示，支持宇宙语言，模特美丽动人、大长腿");

        Object obj = methodProxy.invokeSuper(o, objects);

        System.out.println("快递到家，不满意10倍赔偿");

        return obj;
    }
}
