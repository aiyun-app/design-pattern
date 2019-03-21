package com.rainier.observerpattern.guava;

import com.google.common.eventbus.Subscribe;
import com.rainier.observerpattern.Event.LoginEvent;
import com.rainier.observerpattern.Event.SendMessageEvent;

public class Engineer {

    @Subscribe
    public void onCustomerLogin(Object args){
        if (args instanceof LoginEvent) {
            LoginEvent event = (LoginEvent)args;
            System.out.println("用户：" + event.getUserName() + " 登录到了聊天室");
        }
    }

    @Subscribe
    public void onSendMessage(Object args){
        if(args instanceof SendMessageEvent) {
            SendMessageEvent event = (SendMessageEvent)args;
            System.out.println("用户：" + event.getUserName() + " 提问了一个问题：" + event.getQuestion());
        }
    }

}
