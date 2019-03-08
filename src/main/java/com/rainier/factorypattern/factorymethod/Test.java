package com.rainier.factorypattern.factorymethod;

public class Test {
    public static void main(String[] args) {
        Factory factory = new NikeFactory();
        factory.createCoat().getName();

        factory = new VersaceFactory();
        factory.createCoat().getName();

    }
}
