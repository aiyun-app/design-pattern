package com.rainier.decoratorpattern.simple;


public class AndroidPhone extends SmartPhone {

    public AndroidPhone(Dageda phone) {
        super(phone);
    }

    @Override
    public void call() {
        super.call();
        System.out.println("随时随地网购，再也不用担心错过促销信息了");
    }
}
