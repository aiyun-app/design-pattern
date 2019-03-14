package com.rainier.strategypattern.paymentscenario;

import java.math.BigDecimal;

public class Order {

    private String id;
    private BigDecimal amount;


    public Order(String id, BigDecimal amount){
        this.id = id;
        this.amount = amount;
    }

    public void submit(Payment payment){
        System.out.println("订单号：" + id);
        PaymentResult result = payment.pay(this.amount);
        System.out.println(result);
    }
}
