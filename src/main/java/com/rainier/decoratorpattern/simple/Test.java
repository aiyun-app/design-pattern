package com.rainier.decoratorpattern.simple;

public class Test {

    public static void main(String[] args) {
        Dageda phone = new Dageda();
        System.out.println("==========大哥大=========");
        phone.call();
        phone = new WindowsPhone(phone);
        System.out.println("==========微软移动电话=========");
        phone.call();
        phone = new AndroidPhone(phone);
        System.out.println("==========Android移动电话=========");
        phone.call();
        phone = new IOSPhone(phone);
        System.out.println("==========IOS移动电话=========");
        phone.call();
    }
}
