package com.rainier.strategypattern.paymentscenario;

import java.math.BigDecimal;

public class JDPay{
    //@Override
    public PaymentResult pay(BigDecimal amount) {
        System.out.println("京东支付，金额 [" + amount + "]");
        return new PaymentResult("200", "京东支付成功!", amount);
    }
}
