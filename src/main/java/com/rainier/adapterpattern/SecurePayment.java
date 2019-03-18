package com.rainier.adapterpattern;

import com.rainier.strategypattern.paymentscenario.PaymentResult;

import java.math.BigDecimal;

public interface SecurePayment {
    PaymentResult pay(String token, BigDecimal amount);
}
