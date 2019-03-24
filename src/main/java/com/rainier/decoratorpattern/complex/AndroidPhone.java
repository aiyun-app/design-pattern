package com.rainier.decoratorpattern.complex;

public class AndroidPhone extends SmartPhone {

    public AndroidPhone(MobilePhone phone) {
        super(phone);
    }

    @Override
    public void call() {
        super.call();
        System.out.println("随时随地网购，再也不用担心错过促销信息了");
    }
}
