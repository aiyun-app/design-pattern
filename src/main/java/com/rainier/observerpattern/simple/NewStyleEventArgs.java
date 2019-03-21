package com.rainier.observerpattern.simple;

public class NewStyleEventArgs extends EventArgs {
    private String message;

    public NewStyleEventArgs(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
