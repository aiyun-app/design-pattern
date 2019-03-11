package com.rainier.singletonpattern.lazy;

public class InnerClassCodeGenerator {

    private InnerClassCodeGenerator(){

    }

    public static final InnerClassCodeGenerator getInstance(){
        return CodeGeneratorHandler.INSTANCE;
    }

    public void getNextCode(){
        System.out.println("生成新单号");
    }

    //内部静态类，在
    private static class CodeGeneratorHandler{
        private static final InnerClassCodeGenerator INSTANCE = new InnerClassCodeGenerator();
    }
}

