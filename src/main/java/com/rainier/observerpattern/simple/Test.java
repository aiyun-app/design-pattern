package com.rainier.observerpattern.simple;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        Coat coat = new Coat(BigDecimal.valueOf(10000));
        Girl girl = new Girl();
        coat.addObserver(girl);
        Boy boy = new Boy();
        coat.addObserver(boy);
        coat.discount();
        coat.stock();

    }
}
