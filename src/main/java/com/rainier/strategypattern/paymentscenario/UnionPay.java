package com.rainier.strategypattern.paymentscenario;

import java.math.BigDecimal;

public class UnionPay implements Payment {
    @Override
    public PaymentResult pay(BigDecimal amount) {
        System.out.println("银联支付，金额 [" + amount + "]");
        return new PaymentResult("200", "银联支付成功!", amount);
    }
}
