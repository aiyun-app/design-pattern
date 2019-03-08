package com.rainier.factorypattern.simple;

public class Test {
    public static void main(String[] args) {

        WorkShop.createCoat("耐克").getName();
        WorkShop.createCoat("范思哲").getName();

    }
}
