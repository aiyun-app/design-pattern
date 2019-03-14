package com.rainier.strategypattern.promotionscenario;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {


        Order order = new Order("00002", BigDecimal.valueOf(20000));
        order.calculate();

    }
}
