package com.rainier.singletonpattern.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


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
