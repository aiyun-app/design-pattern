package com.rainier.observerpattern.my.core;

public class EventHandler {

    private String methodName;

    private Class<?> eventClass;

    public EventHandler(String methodName, Class<?> eventClass) {
        this.methodName = methodName;
        this.eventClass = eventClass;
    }

    public String getMethodName() {
        return methodName;
    }

    public Class<?> getEventClass() {
        return eventClass;
    }
}
