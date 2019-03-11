package com.rainier.singletonpattern.lazy;


import com.rainier.singletonpattern.hungry.CodeGenerator;

import java.lang.reflect.Constructor;
import java.util.concurrent.CountDownLatch;

public class Test {

    public static void main(String[] args) {
        //TestSimple(50);
        //TestSimple2();
        //TestDoubleCheck();
        //TestInnerClass(50);
    }

    private static void TestSimple(int threadCount){

        CountDownLatch latch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        latch.await();
                    }
                    catch (Exception ex){
                        ex.printStackTrace();
                    }
                    try {
                        System.out.println("线程：" + Thread.currentThread().getName()  + SimpleCodeGenerator.getInstance());
                    }
                    catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            }).start();

            latch.countDown();
        }
    }

    private static void TestSimple2(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":" + SimpleCodeGenerator.getInstance());
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":" + SimpleCodeGenerator.getInstance());
            }
        });

        thread1.start();
        thread2.start();
        System.out.println("结束");
    }

    private static void TestDoubleCheck(){

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":" + DoubleCheckCodeGenerator.getInstance());
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":" + DoubleCheckCodeGenerator.getInstance());
            }
        });

        thread1.start();
        thread2.start();
        System.out.println("结束");
    }

    private static void TestInnerClass(int threadCount){
        CountDownLatch latch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        latch.await();
                    }
                    catch (Exception ex){
                        ex.printStackTrace();
                    }
                    try {
                        System.out.println("线程：" + Thread.currentThread().getName()  + InnerClassCodeGenerator.getInstance());
                    }
                    catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            }).start();
            latch.countDown();
        }
    }



}






