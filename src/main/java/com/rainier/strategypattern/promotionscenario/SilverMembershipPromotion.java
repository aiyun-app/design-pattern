package com.rainier.strategypattern.promotionscenario;

import java.math.BigDecimal;

public class SilverMembershipPromotion extends MembershipPromotion {


    @Override
    public BigDecimal discount(BigDecimal amount) {
        System.out.println("银卡会员0.9折");
        return amount.multiply(BigDecimal.valueOf(0.9));
    }
}
