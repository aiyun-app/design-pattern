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


2.懒汉式  

简单实现懒汉式单例模式，在多线程的情况下，会出现问题，是线程不安全的实现方式。  
public class SimpleCodeGenerator {

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

双重检查方式实现单例模式，通过加锁并且两次检查类是否已经被实例化确保单实例  
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

内部静态类方式实现单例模式  
根据jvm规范，当某对象第一次调用InnerClassCodeGenerator.getInstance()时，InnerClassCodeGenerator类被首次主动使用，jvm对其进行初始化（此时并不会调用InnerClassCodeGenerator()构造方法;进行InnerClassCodeGenerator的类加载，初始化静态变量），然后InnerClassCodeGenerator调用getInstance()方法，该方法中，又首次主动调用了CodeGeneratorHandler类，所以要对CodeGeneratorHandler类进行初始化（类的静态变量首先加载，进行初始化），初始化中，INSTANCE常量被赋值时才调用了 InnerClassCodeGenerator的构造方法InnerClassCodeGenerator()，完成了实例化并返回该实例。
当再有对象（也许是在别的线程中）再次调用InnerClassCodeGenerator.getInstance()时，因为已经初始化过了，不会再进行初始化步骤，所以直接返回INSTANCE常量即同一个InnerClassCodeGenerator实例。  

public class InnerClassCodeGenerator {

    private InnerClassCodeGenerator(){

    }

    public static final InnerClassCodeGenerator getInstance(){
        return CodeGeneratorHandler.INSTANCE;
    }

    public void getNextCode(){
        System.out.println("生成新单号");
    }

    
    private static class CodeGeneratorHandler{
        private static final InnerClassCodeGenerator INSTANCE = new InnerClassCodeGenerator();
    }
}

3.注册式  

注册式单例又称为登记式单例，就是将每一个实例都登记到某一个地方，使用唯一的标 识获取实例。注册式单例有两种写法:一种为容器缓存，一种为枚举登记  

枚举登记：  
public enum EnumCodeGenerator {
    INSTANCE;

    public static EnumCodeGenerator getInstance(){
        return INSTANCE;
    }

    public void getNextCode(){
        System.out.println("生成新单号");
    }
}

容器缓存登记：  

public class ContainerCodeGenerator {
    
    private ContainerCodeGenerator(){}
    
    private static Map<String,Object> containier = new ConcurrentHashMap<String,Object>();
    
    public static Object getInstance(String className){
        
        synchronized (containier) {
            if (!containier.containsKey(className)) {
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    containier.put(className, obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return obj;
            } else {
                return containier.get(className);
            }
        }
    }
}


4.破坏单例模式  

通过反射的方式，可以破坏单例模式，因此需要在单例模式的私有构造函数中进行必要的判断，不允许外部调用构造函数或者在构造函数中判断是否实例已经初始化了，如果已经实例化了，则不允许再次实例化  
private static void newInstance(Class clazz){

        try {
            Constructor c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);
            System.out.println(c.newInstance());
            System.out.println(c.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


序列化、反序列化方式，如果单例实现类是可以被序列化的，则通过序列化、反序列化的方式是可以破坏单例模式的，因此需要在单例类中添加如下方法（枚举注册方式的单例实现不需要添加次方法）

    private Object readResolve(){
        return  instance;
    }
查看ObjectInputStream 类的 readObject()方法源代码，可以找到为什么加入下面代码就可以解决问题  
    
public class SerializableTest{

    public static void main(String[] args) {

        Object obj = UpgradeDoubleCheckCodeGenerator.getInstance();

        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {

            fileOutputStream = new FileOutputStream("SeriableSingleton.obj");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();


            fileInputStream = new FileInputStream("SeriableSingleton.obj");
            objectInputStream = new ObjectInputStream(fileInputStream);
            Object obj2 = objectInputStream.readObject();

            System.out.println(obj);
            System.out.println(obj2);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        
    }
}




