package com.rainier.templatepattern;

import java.math.BigDecimal;

public class NoteBookPurchase extends Purchase {

    public NoteBookPurchase(String userName, BigDecimal amount) {
        super(userName, amount);
    }

    @Override
    protected void generalManagerApprove() {
        System.out.println("总经理审批完成");
    }

    @Override
    public boolean needGMApprove() {
        return this.getAmount().compareTo(BigDecimal.valueOf(20000)) > 0 ? true : false;
    }
}
