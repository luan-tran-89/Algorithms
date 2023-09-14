package com.interview.kforce.first.q5;

/**
 * @author gasieugru
 */
public class Parent {
    protected int age;

    @Override
    public void finalize() throws Throwable {
        System.out.println("...");
    }

    public static void main(String[] args) {

    }
}
