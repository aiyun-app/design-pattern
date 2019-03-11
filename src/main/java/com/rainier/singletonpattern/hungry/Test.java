package com.rainier.singletonpattern.hungry;

import java.util.concurrent.CountDownLatch;

public class Test {

    public static void main(String[] args) {

        System.out.println(CodeGenerator.getInstance());
        System.out.println(CodeGenerator.getInstance());
//        int threadCount = 50;
//        CountDownLatch latch = new CountDownLatch(threadCount);
//        for (int i = 0; i < threadCount; i++){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try{
//                        latch.await();
//                    }
//                    catch (Exception ex){
//                        ex.printStackTrace();
//                    }
////                    long begin = System.currentTimeMillis();
//                    try {
//                        System.out.println("线程：" + Thread.currentThread().getName()  + CodeGenerator.getInstance());
//                    }
//                    catch (Exception ex){
//                        ex.printStackTrace();
//                    }
//                    finally {
////                        long end = System.currentTimeMillis();
////                        System.out.println("线程：" + Thread.currentThread().getName() +" 执行时间："+ (end-end) + "毫米");
//                    }
//                }
//            }).start();
//
//            latch.countDown();
//        }
    }
}
