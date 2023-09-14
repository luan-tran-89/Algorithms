package com.common.designPattern.observers;

/**
 * @author gasieugru
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    void update() {
        System.out.println("Binary Observer " + this.subject.getState());
    }
}
