package com.rainier.strategypattern.paymentscenario;

import com.rainier.utility.Common;

import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) {
        Order order = new Order("0001",BigDecimal.valueOf(1000));
        System.out.println("请选择支付类型：ALI_PAY、WECHAT_PAY、UNION_PAY");
        try {
            String name = Common.readConsoleLine();
            Payment payment = PayType.valueOf(name).getPayment();
            order.submit(payment);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
