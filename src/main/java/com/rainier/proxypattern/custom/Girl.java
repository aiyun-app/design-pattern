package com.rainier.proxypattern.custom;

public class Girl implements Person {
    @Override
    public void buy() {
        System.out.println("买个男的");
    }
}
