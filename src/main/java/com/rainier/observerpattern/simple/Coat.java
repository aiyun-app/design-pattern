package com.rainier.observerpattern.simple;

import java.math.BigDecimal;

public class Coat extends Observable {

    private BigDecimal price;

    public Coat(BigDecimal price){
        this.price = price;
    }

    public void discount(){
        BigDecimal oldPrie = this.price;

        this.price = this.price.multiply(BigDecimal.valueOf(0.5));

        DiscountEventArgs args = new DiscountEventArgs(oldPrie, this.price);
        notifyObserver(args);
    }

    public void stock(){
        NewStyleEventArgs args = new NewStyleEventArgs("春季新款到货");
        notifyObserver(args);
    }

    @Override
    protected void notifyObserver(EventArgs args) {
        for (Observer obsever:
             observerList) {
            obsever.update(args);
        }
    }

}
