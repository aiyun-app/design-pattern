package com.rainier.singletonpattern.hungry;



public class CodeGenerator {

    //饿汉式，直接初始化静态成员变量
    private static final CodeGenerator INSTANCE = new CodeGenerator();

    private  CodeGenerator(){

    }

    public static final CodeGenerator getInstance(){
        return INSTANCE;
    }

    public void getNextCode(){
        System.out.println("生成新单号");
    }
}

