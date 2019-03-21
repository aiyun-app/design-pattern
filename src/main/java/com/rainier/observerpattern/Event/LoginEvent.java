package com.rainier.observerpattern.Event;

public class LoginEvent extends Event {
    private String userName;

    public LoginEvent(Object sender, String userName) {
        super(sender);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }


}
