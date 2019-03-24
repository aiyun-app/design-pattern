package com.rainier.decoratorpattern.simple;


public class WindowsPhone extends SmartPhone {
    public WindowsPhone(Dageda phone) {
        super(phone);
    }

    @Override
    public void call() {
        super.call();
        System.out.println("随时随地办公，再也不用担心错过一封邮件了");
    }
}
