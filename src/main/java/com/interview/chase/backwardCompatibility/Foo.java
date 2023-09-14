package com.interview.chase.backwardCompatibility;

/**
 * @author gasieugru
 */
public interface Foo {

    static void bar() {
        System.out.println("bar");
    }

    void foo();

    default void newFoo() {
        System.out.println("newFoo");
    };
}
