package com.common.designPattern.observers;

/**
 * @author gasieugru
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    void update() {
        System.out.println("Octal Observer " + this.subject.getState());
    }
}
