package com.rainier.observerpattern.simple;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

    protected List<Observer> observerList = new ArrayList<>();
    public synchronized void addObserver(Observer observer){
        if (observerList.contains(observer))
            return;
        observerList.add(observer);
    }

    public synchronized void  removeObserver(Observer observer){
        if(observerList.contains(observer)){
            observerList.remove(observer);
        }
    }

    protected abstract void notifyObserver(EventArgs args);

}
