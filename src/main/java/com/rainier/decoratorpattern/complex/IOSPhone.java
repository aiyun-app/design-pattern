package com.rainier.decoratorpattern.complex;

public class IOSPhone extends SmartPhone {

    public IOSPhone(MobilePhone phone) {
        super(phone);
    }

    @Override
    public void call() {
        super.call();
        System.out.println("随时随地玩游戏，再也不用担心被超越了");
    }
}
