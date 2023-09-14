package com.interview.takecommand;

/**
 * @author gasieugru
 */
public interface ToasterAction {

    void startAll();

    void startAtPosition(int position);

    void stopAll();

    void stopAtPosition(int position);

    void printSlotStatus();

}
