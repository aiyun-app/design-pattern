package com.rainier.adapterpattern.objectadapter;


import com.rainier.adapterpattern.SecurePayment;
import com.rainier.strategypattern.paymentscenario.WeChatPay;

import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) {

        try {

            SecurePayment payment = new PaymentAdapter(new WeChatPay());
            payment.pay("123456789", BigDecimal.valueOf(28900));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
