package com.rainier.strategypattern.promotionscenario;

import java.math.BigDecimal;

public class GoldenMembershipPromotion extends MembershipPromotion {

    @Override
    public BigDecimal discount(BigDecimal amount) {
        System.out.println("金卡会员0.8折");
        return amount.multiply(BigDecimal.valueOf(0.8));
    }
}
