package com.rainier.strategypattern.paymentscenario;

public enum PayType {
    ALI_PAY(new AliPay()),
    WECHAT_PAY(new WeChatPay()),
    UNION_PAY(new UnionPay()),
    JD_PAY(new JDPay());

    private  Payment payment;
    PayType(Payment payment){
        this.payment = payment;
    }

    public Payment getPayment() {
        return payment;
    }
}
