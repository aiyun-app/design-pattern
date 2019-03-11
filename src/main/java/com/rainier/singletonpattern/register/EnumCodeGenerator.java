package com.rainier.singletonpattern.register;


public enum EnumCodeGenerator {
    INSTANCE;

    public static EnumCodeGenerator getInstance(){
        return INSTANCE;
    }

    public void getNextCode(){
        System.out.println("生成新单号");
    }
}
