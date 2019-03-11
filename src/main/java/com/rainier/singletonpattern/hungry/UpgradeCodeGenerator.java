package com.rainier.singletonpattern.hungry;

import java.io.Serializable;

public class UpgradeCodeGenerator implements Serializable {

    private static final UpgradeCodeGenerator INSTANCE = new UpgradeCodeGenerator();

    //饿汉式增强，防止通过反射方式实例化对象
    private UpgradeCodeGenerator(){
        if (UpgradeCodeGenerator.INSTANCE != null) {
            throw new RuntimeException("单例模式，不能直接调用构造方法");
        }
    }

    public static UpgradeCodeGenerator getInstance(){
        return INSTANCE;
    }

    public void getNextCode(){
        System.out.println("生成新单号");
    }

    //饿汉式增强，防止通过序列化，返序列化的方式实例化对象
    //查看ObjectInputStream 类的 readObject()方法源代码，可以找到为什么加入下面代码就可以解决问题
    private  Object readResolve(){
        return  INSTANCE;
    }
}

