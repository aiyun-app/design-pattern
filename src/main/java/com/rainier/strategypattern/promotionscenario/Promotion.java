package com.rainier.strategypattern.promotionscenario;

import java.math.BigDecimal;

public interface Promotion {
    //打折促销
    BigDecimal discount(BigDecimal amount);
}

