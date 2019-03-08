package com.rainier.factorypattern.abstractfactory;

public class VersaceShose implements Shose {
    @Override
    public String getName() {
        System.out.println("范思哲皮鞋");
        return "范思哲皮鞋";
    }
}
