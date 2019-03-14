package com.rainier.strategypattern.paymentscenario;

import java.math.BigDecimal;

public interface Payment {
    PaymentResult pay(BigDecimal amount);
}
