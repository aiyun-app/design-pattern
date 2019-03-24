package com.rainier.decoratorpattern.simple;

import com.rainier.decoratorpattern.simple.SmartPhone;

public class IOSPhone extends SmartPhone {

    public IOSPhone(Dageda phone) {
        super(phone);
    }

    @Override
    public void call() {
        super.call();
        System.out.println("随时随地玩游戏，再也不用担心被超越了");
    }
}
