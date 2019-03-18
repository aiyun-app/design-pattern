package com.rainier.adapterpattern.classadapter;

import com.rainier.adapterpattern.SecurePayment;
import com.rainier.strategypattern.paymentscenario.AliPay;
import com.rainier.strategypattern.paymentscenario.Payment;
import com.rainier.strategypattern.paymentscenario.PaymentResult;

import java.math.BigDecimal;
import java.util.ArrayList;

public class AliPaymentAdapter extends AliPay implements SecurePayment {

    @Override
    public PaymentResult pay(String token, BigDecimal amount) {

        System.out.println("token [" + token + "] 验证成功, 可以支付");
        return super.pay(amount);
    }

    private int cal(int i,int j){
        return  i +j;
    }

}
