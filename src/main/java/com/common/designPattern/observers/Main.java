package com.common.designPattern.observers;

/**
 * @author gasieugru
 */
public class Main {

    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer observer1 = new BinaryObserver(subject);
        Observer observer2 = new OctalObserver(subject);
        subject.setState(15);

        subject.setState(10);
    }
}
