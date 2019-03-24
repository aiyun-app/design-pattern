package com.rainier.decoratorpattern.complex;

public class WindowsPhone extends SmartPhone {
    public WindowsPhone(MobilePhone phone) {
        super(phone);
    }

    @Override
    public void call() {
        super.call();
        System.out.println("随时随地办公，再也不用担心错过一封邮件了");
    }
}
