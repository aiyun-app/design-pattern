package com.rainier.singletonpattern.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class UpgradeContainerCodeGenerator {
    private UpgradeContainerCodeGenerator(){
        throw new RuntimeException("单例模式，不能直接调用构造方法");
    }
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
