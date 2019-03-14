package com.rainier.strategypattern.promotionscenario;

import java.math.BigDecimal;

public class DefaultMembershipPromotion extends MembershipPromotion {
    @Override
    public BigDecimal discount(BigDecimal amount) {
        return amount;
    }
}
