package com.rainier.observerpattern.guava;

import com.google.common.eventbus.EventBus;

public class Test {
    public static void main(String[] args) {

        Engineer engineer = new Engineer();
        Customer customer = new Customer("Amy");
        customer.RegisterObserver(engineer);
        customer.Login();
        customer.AskQuestion("Guava怎么发音？？");
    }
}
