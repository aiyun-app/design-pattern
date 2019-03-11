package com.rainier.singletonpattern.threadlocal;


public class ThreadLocalCodeGenerator {
    private static final ThreadLocal<ThreadLocalCodeGenerator> threadLocalInstance =
            new ThreadLocal<ThreadLocalCodeGenerator>(){
                @Override
                protected ThreadLocalCodeGenerator initialValue() {
                    return new ThreadLocalCodeGenerator();
                }
            };

    private ThreadLocalCodeGenerator(){}

    public static ThreadLocalCodeGenerator getInstance(){
        return threadLocalInstance.get();
    }
}
