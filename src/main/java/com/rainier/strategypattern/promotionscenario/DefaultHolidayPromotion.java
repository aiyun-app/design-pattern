package com.rainier.strategypattern.promotionscenario;

import java.math.BigDecimal;

public class DefaultHolidayPromotion extends NationalDayPromotion {
    @Override
    public BigDecimal discount(BigDecimal amount) {
        System.out.println("抱歉，不是法定假日没有折扣");
        return amount;
    }
}
