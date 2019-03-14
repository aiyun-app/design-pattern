package com.rainier.strategypattern.promotionscenario;

import java.math.BigDecimal;
import java.util.Date;

public class NationalDayPromotion extends HolidayPromotion {


    @Override
    public BigDecimal discount(BigDecimal amount) {
        System.out.println("国庆促销全场0.8折");
        return amount.multiply(BigDecimal.valueOf(0.8));
    }


}
