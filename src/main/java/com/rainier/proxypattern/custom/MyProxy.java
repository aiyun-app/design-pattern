package com.rainier.proxypattern.custom;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxy {

    public static final String ln = "\r\n";

    public static Object newProxyInstance(MyClassLoader classLoader, Class<?>[] interfaces, MyInvocationHandler handler){
        try {
            //1、动态生成源代码.java文件

            String src = generateSrc(interfaces);

            //2、Java文件输出磁盘
            String filePath = MyProxy.class.getResource("").getPath();
            File javaFile = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(javaFile);
            fw.write(src);
            fw.flush();
            fw.close();

            //3、把生成的.java文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manage = compiler.getStandardFileManager(null,null,null);
            Iterable iterable = manage.getJavaFileObjects(javaFile);

            JavaCompiler.CompilationTask task = compiler.getTask(null,manage,null,null,null,iterable);
            task.call();
            manage.close();

            //4、编译生成的.class文件加载到JVM中来
            Class proxyClass =  classLoader.findClass("$Proxy0");
            Constructor constructor = proxyClass.getConstructor(InvocationHandler.class);
            javaFile.delete();

            //5、返回字节码重组以后的新的代理对象
            return constructor.newInstance(handler);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    private static String generateSrc(Class<?>[] interfaces){

        if (interfaces.length ==0){
            throw new RuntimeException("没有定义接口");
        }

        StringBuffer sb = new StringBuffer();
        sb.append("package com.rainier.proxypattern.custom;" + ln);
        sb.append("import java.lang.reflect.Method;" + ln);
        sb.append("public class $Proxy0 implements " + interfaces[0].getName());
        for(int i = 1; i < interfaces.length; i++){
            sb.append(",");
            sb.append(interfaces[i].getName());
        }
        sb.append("{" + ln);


        sb.append("InvocationHandler h;" + ln);

        sb.append("public $Proxy0(InvocationHandler h) { " + ln);

        sb.append("this.h = h;");

        sb.append("}" + ln);


        for(Class<?> clazz : interfaces ){
            for (Method m : clazz.getMethods()){
                sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "() {" + ln);
                sb.append("try{" + ln);
                sb.append("Method m = " + clazz.getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{});" + ln);
                sb.append("this.h.invoke(this,m,null);" + ln);
                sb.append("}catch(Throwable e){" + ln);
                sb.append("e.printStackTrace();" + ln);
                sb.append("}" + ln);
                sb.append("}" + ln);
            }
        }


        sb.append("}" + ln);

        return sb.toString();
    }

}


