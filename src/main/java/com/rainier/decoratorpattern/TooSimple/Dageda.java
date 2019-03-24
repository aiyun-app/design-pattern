package com.rainier.decoratorpattern.TooSimple;


public class Dageda implements MobilePhone {

    @Override
    public void call() {
        System.out.println("我能打无线电话，以后出门在外再也不用担心错过妹子约会了");
    }
}
