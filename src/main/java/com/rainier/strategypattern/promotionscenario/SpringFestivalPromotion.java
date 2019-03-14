package com.rainier.strategypattern.promotionscenario;

import java.math.BigDecimal;
import java.util.Date;

public class SpringFestivalPromotion extends HolidayPromotion {

    @Override
    public BigDecimal discount(BigDecimal amount) {
        System.out.println("春节促销全场0.5折");
        return amount.multiply(BigDecimal.valueOf(0.5));
    }
}
