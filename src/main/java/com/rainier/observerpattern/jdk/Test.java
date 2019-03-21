package com.rainier.observerpattern.jdk;

public class Test {

    public static void main(String[] args) {
        Engineer engineer = new Engineer();

        Customer customer = new Customer("Andy");
        customer.addObserver(engineer);

        customer.Login();
        customer.AskQuestion("Java 观察者模式我不太了解");

    }
}
