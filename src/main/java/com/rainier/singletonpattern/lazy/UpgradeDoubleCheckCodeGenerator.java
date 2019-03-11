package com.rainier.singletonpattern.lazy;

import java.io.Serializable;

public class UpgradeDoubleCheckCodeGenerator implements Serializable {

    private volatile static UpgradeDoubleCheckCodeGenerator instance = null;
    private volatile static boolean flag = false;

    //防止通过反射方式实例化对象
    private UpgradeDoubleCheckCodeGenerator(){
        if(UpgradeDoubleCheckCodeGenerator.flag == true){
            throw new RuntimeException("不允许创建多个实例");
        }
        UpgradeDoubleCheckCodeGenerator.flag = true;
    }

    public static UpgradeDoubleCheckCodeGenerator getInstance(){
        if (instance == null){
            synchronized (UpgradeDoubleCheckCodeGenerator.class)
            {
                if(instance == null){
                    instance = new UpgradeDoubleCheckCodeGenerator();
                }
            }
        }
        return instance;
    }

    public synchronized UpgradeDoubleCheckCodeGenerator Instance(){
        if (instance == null){
             instance = new UpgradeDoubleCheckCodeGenerator();
        }
        return instance;
    }

    public void getNextCode(){
        System.out.println("生成新单号");
    }

    //饿汉式增强，防止通过序列化，返序列化的方式实例化对象
    //查看ObjectInputStream 类的 readObject()方法源代码，可以找到为什么加入下面代码就可以解决问题
    private Object readResolve(){
        return  instance;
    }
}

