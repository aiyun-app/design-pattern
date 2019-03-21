package com.rainier.observerpattern.guava;

import com.google.common.eventbus.EventBus;
import com.rainier.observerpattern.Event.LoginEvent;
import com.rainier.observerpattern.Event.SendMessageEvent;

public class Customer {

    private String userName;
    private EventBus eventBus;

    public Customer(String userName) {
        this.userName = userName;
        eventBus = new EventBus();
    }

    public void RegisterObserver(Object obj){
        eventBus.register(obj);
    }

    public void Login(){
        LoginEvent loginEvent = new LoginEvent(this, userName);
        eventBus.post(loginEvent);
    }

    public void AskQuestion(String question){
        SendMessageEvent event = new SendMessageEvent(this, userName, question);
        eventBus.post(event);
    }
}
