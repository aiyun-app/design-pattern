package com.rainier.strategypattern.paymentscenario;

import java.math.BigDecimal;

public class WeChatPay implements Payment {
    @Override
    public PaymentResult pay(BigDecimal amount) {
        System.out.println("微信支付，金额 [" + amount + "]");
        return new PaymentResult("200", "微信支付成功!", amount);
    }
}
