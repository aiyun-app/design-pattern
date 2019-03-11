package com.rainier.singletonpattern.lazy;

public class SimpleCodeGenerator {

    //简单实现懒汉式单例模式，在多线程的情况下，会出现问题，是线程不安全的实现方式。
    private static SimpleCodeGenerator instance = null;

    private SimpleCodeGenerator(){}

    public static SimpleCodeGenerator getInstance(){
        if (instance == null){
            instance = new SimpleCodeGenerator();
        }
        return instance;
    }

    public void getNextCode(){
        System.out.println("生成新单号");
    }
}

