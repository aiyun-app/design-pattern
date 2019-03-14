package com.rainier.strategypattern.promotionscenario;

import java.math.BigDecimal;

public class DiamondMembershipPromotion extends MembershipPromotion {


    @Override
    public BigDecimal discount(BigDecimal amount) {
        System.out.println("钻石会员0.6折");
        return amount.multiply(BigDecimal.valueOf(0.6));
    }
}
