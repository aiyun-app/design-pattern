package com.rainier.proxypattern.custom;

public class Test {
    public static void main(String[] args) {
        try {
            Person person = (Person) new Agency().getProxy(new Girl());
            person.buy();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
