package com.rainier.decoratorpattern.TooSimple;

public class Test {

    public static void main(String[] args) {
        MobilePhone phone = new Dageda();
        System.out.println("==========大哥大=========");
        phone.call();
        phone = new SmartPhone(phone);
        System.out.println("==========智能移动电话=========");
        phone.call();
    }
}
