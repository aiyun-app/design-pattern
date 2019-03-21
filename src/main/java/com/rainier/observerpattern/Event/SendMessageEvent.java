package com.rainier.observerpattern.Event;

import com.rainier.observerpattern.my.core.Event;

public class SendMessageEvent extends Event {
    private String userName;
    private String question;

    public SendMessageEvent(Object sender, String userName, String question) {
        super(sender);
        this.userName = userName;
        this.question = question;
    }

    public String getUserName() {
        return userName;
    }

    public String getQuestion() {
        return question;
    }



}
