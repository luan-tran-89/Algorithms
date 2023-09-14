package com.common.designPattern.observers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gasieugru
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        this.notifyAllObservers();
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void notifyAllObservers() {
        this.observers.forEach(observer -> observer.update());
    }
}
