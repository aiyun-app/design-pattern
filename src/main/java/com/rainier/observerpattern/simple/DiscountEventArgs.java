package com.rainier.observerpattern.simple;

import java.math.BigDecimal;

public class DiscountEventArgs extends EventArgs {
    private BigDecimal oldPrice;
    private BigDecimal newPrice;

    public DiscountEventArgs(BigDecimal oldPrice, BigDecimal newPrice) {
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
    }

    public BigDecimal getOldPrice() {
        return oldPrice;
    }

    public BigDecimal getNewPrice() {
        return newPrice;
    }
}
