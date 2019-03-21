package com.rainier.observerpattern.my.chat;

import com.rainier.observerpattern.Event.LoginEvent;
import com.rainier.observerpattern.Event.SendMessageEvent;
import com.rainier.observerpattern.my.core.EventHandler;
import com.rainier.observerpattern.my.core.Observable;
import com.rainier.observerpattern.my.core.Observer;

public class Engineer implements Observer {


    private void userLoginHandler(LoginEvent event) {
        System.out.println("用户：" + event.getUserName() + " 登录到了聊天室");
    }

    private void receiveMessageHandler(SendMessageEvent event){

        System.out.println("用户：" + event.getUserName() + " 提问了一个问题：" + event.getQuestion()); }


    @Override
    public void register(Observable observable) {
        try {

            EventHandler loginHandler = new EventHandler("userLoginHandler", LoginEvent.class);
            observable.addObserver(this, loginHandler);

            EventHandler messageHandler = new EventHandler("receiveMessageHandler", SendMessageEvent.class);
            observable.addObserver(this, messageHandler);

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
