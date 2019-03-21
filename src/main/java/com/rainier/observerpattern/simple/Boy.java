package com.rainier.observerpattern.simple;

public class Boy implements Observer {
    @Override
    public void update(EventArgs args) {
        if(args instanceof NewStyleEventArgs){
            NewStyleEventArgs newStyleEventArgs = (NewStyleEventArgs)args;
            System.out.println(this.getClass().getName() + "你好，"+ newStyleEventArgs.getMessage());
        }
    }
}
