package com.rainier.observerpattern.Event;

public class Event {
    private Object sender;
    public Event(Object sender){
        this.sender = sender;
    }

    public Object getSender() {
        return sender;
    }
}
