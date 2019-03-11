package com.rainier.singletonpattern.lazy;

public class DoubleCheckCodeGenerator {

    // java中使用双重检查锁定机制,由于Java编译器和JIT的优化的原因系统无法保证我们期望的执行次序。
    // 在java5.0修改了内存模型,使用volatile声明的变量可以强制屏蔽编译器和JIT的优化工作

    //volatile保证原子操作
    // volatile 的功能:
    //1. 避免编译器将变量缓存在寄存器里
    //2. 避免编译器调整代码执行的顺序
    //优化器在用到这个变量时必须每次都小心地重新读取这个变量的值，而不是使用保存在寄存器里的备份
    private volatile static DoubleCheckCodeGenerator instance = null;

    private DoubleCheckCodeGenerator(){
    }

    //尽量将"加锁"推迟,只在需要时"加锁
    public static DoubleCheckCodeGenerator getInstance(){
        if (instance == null){
            synchronized (DoubleCheckCodeGenerator.class)
            {
                if(instance == null){
                    instance = new DoubleCheckCodeGenerator();
                }
            }
        }
        return instance;
    }

    //通过synchronized 给方法加锁，确保调用方法时，线程安全。但是synchronized锁会影响性能
    public synchronized DoubleCheckCodeGenerator Instance(){
        if (instance == null){
             instance = new DoubleCheckCodeGenerator();
        }
        return instance;
    }

    public void getNextCode(){
        System.out.println("生成新单号");
    }
}

