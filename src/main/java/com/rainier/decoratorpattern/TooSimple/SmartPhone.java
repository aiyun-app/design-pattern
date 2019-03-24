package com.rainier.decoratorpattern.TooSimple;


public class SmartPhone implements MobilePhone {

    private MobilePhone phone;

    public SmartPhone(MobilePhone phone) {
        this.phone = phone;
    }

    @Override
    public void call() {
        phone.call();
        System.out.println("还可以发短信，完俄罗斯方块");
    }
}
