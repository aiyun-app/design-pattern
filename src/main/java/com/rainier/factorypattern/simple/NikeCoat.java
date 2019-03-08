package com.rainier.factorypattern.simple;

public class NikeCoat implements Coat {
    @Override
    public String getName() {
        System.out.println("耐克运动服");
        return "耐克运动服";
    }
}
