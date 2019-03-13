package com.rainier.proxypattern.custom;

import java.lang.reflect.Method;

public class Agency implements MyInvocationHandler {

    private Object target;
    public Object getProxy(Object obj) throws Exception{
        this.target = obj;
        Class<?> clazz = target.getClass();
        return MyProxy.newProxyInstance(new MyClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.target,args);
        after();
        return obj;
    }

    private void before(){
        System.out.println("我是中介，世界上所有的需要都能帮你解决");
        System.out.println("已经帮您验货，质量没有问题");
    }

    private void after(){
        System.out.println("确认交易完成，填写满意度问卷调查");
    }
}
