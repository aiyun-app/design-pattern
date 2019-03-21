package com.rainier.observerpattern.my.chat;


public class Test {
    public static void main(String[] args) {
        Customer customer = new Customer("Bobby");

        Engineer engineer = new Engineer();
        engineer.register(customer);

        customer.Login();
        customer.SendMessage("你好，能借点钱不");



    }
}
