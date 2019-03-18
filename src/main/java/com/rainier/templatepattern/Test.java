package com.rainier.templatepattern;

import java.math.BigDecimal;

public class Test {

    public static void main(String[] args) {
        Purchase purchase = new NoteBookPurchase("Bobby", BigDecimal.valueOf(25000));
        System.out.println("==================笔记本电脑采购金额超过2万需要总经理审批=====================");
        purchase.Submit();

        System.out.println("==================笔记本电脑采购金额小于2万会签后直接采购=====================");
        purchase = new NoteBookPurchase("Bobby", BigDecimal.valueOf(18000));
        purchase.Submit();
    }
}
