package com.rainier.singletonpattern.lazy;

public class UpgradeInnerClassCodeGenerator {

    //防止通过反射方式实例化对象
    private UpgradeInnerClassCodeGenerator(){
        if(CodeGeneratorHandler.INSTANCE != null){
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    public static final UpgradeInnerClassCodeGenerator getInstance(){
       return CodeGeneratorHandler.INSTANCE;
    }

    public void getNextCode(){
        System.out.println("生成新单号");
    }

    private static class CodeGeneratorHandler{
        private static final UpgradeInnerClassCodeGenerator INSTANCE = new UpgradeInnerClassCodeGenerator();
    }

    //饿汉式增强，防止通过序列化，返序列化的方式实例化对象
    //查看ObjectInputStream 类的 readObject()方法源代码，可以找到为什么加入下面代码就可以解决问题
    private Object readResolve(){
        return  CodeGeneratorHandler.INSTANCE;
    }
}

