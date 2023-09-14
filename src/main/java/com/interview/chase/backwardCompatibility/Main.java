package com.interview.chase.backwardCompatibility;

/**
 * @author gasieugru
 */
public class Main {

    public static void main(String[] args) {
        Foo bar = new FooImpl();
        bar.newFoo();

        Foo.bar();
        FooImpl.bar();
    }

}
