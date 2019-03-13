package com.rainier.proxypattern;

public class LV implements BagSeller {
    @Override
    public void SaleBag(String color) {
        System.out.println(color + "颜色的LV包");
    }
}
