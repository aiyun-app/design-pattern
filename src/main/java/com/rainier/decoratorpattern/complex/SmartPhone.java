package com.rainier.decoratorpattern.complex;

public class SmartPhone implements MobilePhone {

    private MobilePhone phone;

    public SmartPhone(MobilePhone phone) {
        this.phone = phone;
    }

    @Override
    public void call() {
        phone.call();
    }
}
