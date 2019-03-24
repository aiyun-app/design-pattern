package com.rainier.observerpattern.jdk;

import com.rainier.observerpattern.Event.LoginEvent;
import com.rainier.observerpattern.Event.SendMessageEvent;

import java.util.Observable;

public class Customer extends Observable {

    private String userName;

    public Customer(String userName) {
        this.userName = userName;
    }

    public void Login(){
        setChanged();
        LoginEvent loginEvent = new LoginEvent(this, userName);
        notifyObservers(loginEvent);
    }

    public void AskQuestion(String question){
        SendMessageEvent event = new SendMessageEvent(this, userName, question);
        setChanged();
        notifyObservers(event);
    }
}
