package com.interview.kforce.first.q5;

/**
 * @author gasieugru
 */
public class Child extends Parent {

    @Override
    public void finalize() throws Throwable {
        System.out.println("...");
    }

    int compare(Parent parent) {
        try {
            if (age >= parent.age) {
                throw new IllegalStateException("Child can't be older than parent.");
            }
            return age - parent.age;
        } finally {
            System.out.println("Child age: " + age);
        }
    }

    final int gender() {
        return -1;
    }

    public static void main(String[] args) {

    }
}
