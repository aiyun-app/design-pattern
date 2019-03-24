package com.rainier.decoratorpattern.simple;



public class SmartPhone extends Dageda {

    private Dageda phone;

    public SmartPhone(Dageda phone) {
        this.phone = phone;
    }

    @Override
    public void call() {
        phone.call();
    }
}
