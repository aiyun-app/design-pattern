package com.rainier.strategypattern.promotionscenario;



import java.math.BigDecimal;
import java.util.ArrayList;

public class Order {

    private String id;
    private BigDecimal amount;
    private BigDecimal payAmount;

    public Order(String id, BigDecimal amount){
        this.id = id;
        this.amount = amount;
        this.payAmount = amount;
    }



    public void calculate(){
        System.out.println("订单号：" + this.id + "商品总价：" + this.amount);
        MembershipPromotion membershipPromotion = MembershipPromotionFactory.getPromotion(MembershipLevel.GOLD.name());
        HolidayPromotion holidayPromotion = HolidayPromotionFactory.getPromotion();
        this.payAmount = holidayPromotion.discount(membershipPromotion.discount(this.amount));
        System.out.println("折扣后商品总价："+ this.payAmount);
    }
}
