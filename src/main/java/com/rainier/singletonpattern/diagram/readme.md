
#  目的  
保证一个类仅有一个实例，并提供一个访问它的全局访问点  

#  适用性  
在下面的情况下可以使用 Singleton模式  
• 当类只能有一个实例而且客户可以从一个众所周知的访问点访问它时。  
• 当这个唯一实例应该是通过子类化可扩展的，并且客户应该无需更改代码就能使用一个扩展的实例时。  

#  总结  

单例模式的实现分为如下几种情况  
1. 饿汉式  
   饿汉式分为两种方式  
   第一种方式是直接初始化静态成员变量，保证在任何线程访问之前已经创建类实例，并且通过final 关键字确保静态成员变量不被修改    
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

 第二种方式是通过静态代码块的方式，效果与第一种相同  
public class CodeGenerator2 {

    //饿汉式，在静态代码块中初始化静态成员变量
    private static final CodeGenerator2 INSTANCE ;
    static {
        INSTANCE = new CodeGenerator2();
    }

    private CodeGenerator2(){}

    public static final CodeGenerator2 getInstance(){
        return INSTANCE;
    }

    public void getNextCode(){
        System.out.println("生成新单号");
    }
}


    
2. 懒汉式  

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

   

3. 注册式


