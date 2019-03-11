package com.rainier.singletonpattern.register;


import com.rainier.singletonpattern.lazy.DoubleCheckCodeGenerator;
import com.rainier.singletonpattern.lazy.InnerClassCodeGenerator;
import com.rainier.singletonpattern.lazy.SimpleCodeGenerator;

import java.util.concurrent.CountDownLatch;

public class Test {

    public static void main(String[] args) {
        //TestEnum(50);
        TestContainer(50);
    }

    private static void TestEnum(int threadCount){

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
                        System.out.println("线程：" + Thread.currentThread().getName()  + EnumCodeGenerator.getInstance());
                    }
                    catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            }).start();

            latch.countDown();
        }
    }

    private static void TestContainer(int threadCount){

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
                        System.out.println("线程：" + Thread.currentThread().getName()  + ContainerCodeGenerator.getInstance("com.rainier.singletonpattern.register.Service"));
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






