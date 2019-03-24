package com.rainier.singletonpattern.hungry;


import java.util.concurrent.CountDownLatch;

public class Test {

    public static void main(String[] args) {

//        System.out.println(CodeGenerator.getInstance());
//        System.out.println(CodeGenerator.getInstance());

        TestSimple(20);
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
                        CodeGenerator generator = CodeGenerator.getInstance();
//                        String name = generator.getName();
//                        generator.setName("Name" + Thread.currentThread().getId());
//                        System.out.println("线程名称：" + Thread.currentThread().getName()
//                                + " 线程Id："  + Thread.currentThread().getId()
//                                + " Name: "
//                                + name);

                        System.out.println("线程名称：" + Thread.currentThread().getName()
                                + "  "+ generator);

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
