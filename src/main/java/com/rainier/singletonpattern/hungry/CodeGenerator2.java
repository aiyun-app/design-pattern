package com.rainier.singletonpattern.hungry;

public class CodeGenerator2 {

    //饿汉式，在静态代码块中初始化静态成员变量
    private static final CodeGenerator2 INSTANCE ;
    static {
        INSTANCE = new CodeGenerator2();
    }

    private CodeGenerator2(){}

    public static final CodeGenerator2 getInstance(){
        return INSTANCE;
    }

    public void getNextCode(){
        System.out.println("生成新单号");
    }
}

