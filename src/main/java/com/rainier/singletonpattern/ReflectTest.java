package com.rainier.singletonpattern;

import com.rainier.singletonpattern.hungry.CodeGenerator;
import com.rainier.singletonpattern.hungry.UpgradeCodeGenerator;
import com.rainier.singletonpattern.lazy.DoubleCheckCodeGenerator;
import com.rainier.singletonpattern.lazy.InnerClassCodeGenerator;
import com.rainier.singletonpattern.lazy.UpgradeDoubleCheckCodeGenerator;
import com.rainier.singletonpattern.lazy.UpgradeInnerClassCodeGenerator;
import com.rainier.singletonpattern.register.ContainerCodeGenerator;
import com.rainier.singletonpattern.register.EnumCodeGenerator;

import java.lang.reflect.Constructor;

public class ReflectTest {

    public static void main(String[]args){
//        newInstance(CodeGenerator.class);
//        newInstance(UpgradeCodeGenerator.class);

//        System.out.println(DoubleCheckCodeGenerator.getInstance());
//        System.out.println(DoubleCheckCodeGenerator.getInstance());

//        newInstance(DoubleCheckCodeGenerator.class);
//        newInstance(UpgradeDoubleCheckCodeGenerator.class);

//        newInstance(InnerClassCodeGenerator.class);
//        newInstance(UpgradeInnerClassCodeGenerator.class);

//        newInstance(EnumCodeGenerator.class);

        newInstance(UpgradeDoubleCheckCodeGenerator.class);
    }


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
}


