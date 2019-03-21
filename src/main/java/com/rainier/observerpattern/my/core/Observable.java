package com.rainier.observerpattern.my.core;

import com.rainier.observerpattern.Event.Event;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class Observable {

    protected Map<Object, EventHandler[]> map = new HashMap();
    private static final EventHandler[] EMPTY = {};

    public synchronized void addObserver(Object observer, EventHandler eventHandler) {
        if (this.map == null) {
            this.map = new HashMap<>();
        }
        EventHandler[] array = this.map.get(observer);
        int size = (array != null)
                ? array.length
                : 0;

        EventHandler[] clone = newArray(size + 1);
        clone[size] = eventHandler;
        if (array != null) {
            System.arraycopy(array, 0, clone, 0, size);
        }

        this.map.put(observer, clone);
    }

    private EventHandler[] newArray(int length) {
        return (0 < length)
                ? new EventHandler[length]
                : EMPTY;
    }

    public void raiseEvent(Event event) {

        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            Object observer = entry.getKey();
            EventHandler[] eventHandlers = (EventHandler[])entry.getValue();
            for (EventHandler eventHandler:
                 eventHandlers) {
                if(eventHandler.getEventClass() ==event.getClass()){
                    try {

                        Class clazz = observer.getClass();
                        Method method =  clazz.getDeclaredMethod(eventHandler.getMethodName(), eventHandler.getEventClass());
                        method.setAccessible(true);
                        method.invoke(observer, event);
                    }
                    catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            }

        }
    }
}
