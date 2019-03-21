package com.rainier.observerpattern.jdk;

import com.rainier.observerpattern.Event.LoginEvent;
import com.rainier.observerpattern.Event.SendMessageEvent;

import java.util.Observable;
import java.util.Observer;

public class Engineer implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof LoginEvent) {
            LoginEvent event = (LoginEvent)arg;
            System.out.println("用户：" + event.getUserName() + " 登录到了聊天室");
        }
        else if(arg instanceof SendMessageEvent) {
            SendMessageEvent event = (SendMessageEvent)arg;
            System.out.println("用户：" + event.getUserName() + " 提问了一个问题：" + event.getQuestion());
        }

    }
}
