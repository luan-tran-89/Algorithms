package com.interview.chase.backwardCompatibility;

/**
 * @author gasieugru
 */
public class FooImpl implements Foo {

    static void bar() {
        System.out.println("FooImpl bar");
    }

    @Override
    public void foo() {
        System.out.println("Foo");
    }


//    @Override
//    public void newFoo() {
//        System.out.println("FooImpl newFoo");
//    }
}
