package com.rainier.adapterpattern.objectadapter;

import com.rainier.adapterpattern.SecurePayment;
import com.rainier.strategypattern.paymentscenario.AliPay;
import com.rainier.strategypattern.paymentscenario.Payment;
import com.rainier.strategypattern.paymentscenario.PaymentResult;

import java.math.BigDecimal;

public class PaymentAdapter implements SecurePayment {

    private Payment payment;
    public PaymentAdapter(Payment payment){
        this.payment = payment;
    }

    //原支付接口只需要传人金额即可完成支付，现要求必须验证token是否有效，有效的token才可以完成支付
    @Override
    public PaymentResult pay(String token, BigDecimal amount) {
        System.out.println("token [" + token + "] 验证成功, 可以支付");
        return payment.pay(amount);
    }

}
