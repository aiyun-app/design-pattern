package com.rainier.observerpattern.my.chat;

import com.rainier.observerpattern.Event.LoginEvent;
import com.rainier.observerpattern.Event.SendMessageEvent;
import com.rainier.observerpattern.my.core.Observable;

public class Customer extends Observable {


    public Customer(String userName) {
        this.userName = userName;
    }

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void Login(){
        LoginEvent event = new LoginEvent(this, this.userName);
        raiseEvent(event);
    }

    public void SendMessage(String message){

        SendMessageEvent event = new SendMessageEvent(this, userName, message);
        raiseEvent(event);
    }
}
