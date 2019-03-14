package com.rainier.strategypattern.paymentscenario;

import java.math.BigDecimal;

public class AliPay implements Payment {
    @Override
    public PaymentResult pay(BigDecimal amount) {
        System.out.println("阿里支付，金额 [" + amount + "]");
        return new PaymentResult("200", "阿里支付成功!", amount);
    }
}
