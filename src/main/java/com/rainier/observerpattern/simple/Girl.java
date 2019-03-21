package com.rainier.observerpattern.simple;

public class Girl implements Observer {
    @Override
    public void update(EventArgs args) {
       if(args instanceof DiscountEventArgs){
           DiscountEventArgs discountEventArgs = (DiscountEventArgs)args;
           System.out.println(this.getClass().getName() + "你好，你关注的服装已经降价，原价 "+ discountEventArgs.getOldPrice() + " 现价 " + discountEventArgs.getNewPrice());
       }

    }
}
