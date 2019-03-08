package com.rainier.factorypattern.abstractfactory;

public class Test {
    public static void main(String[] args) {
        ModernFactory factory = new NikeModernFactory();

        factory.createCoat().getName();
        factory.createShose().getName();
    }
}
