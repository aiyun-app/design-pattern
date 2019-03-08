package com.rainier.factorypattern.abstractfactory;

public class NikeShose implements Shose {
    @Override
    public String getName() {
        System.out.println("耐克运动鞋");
        return "耐克运动鞋";
    }
}
