package com.interview.blankfactor.questions;

/**
 * @author gasieugru
 */
public class Q3 {
    public static void main(String[] args) {
        ClassA refA = new ClassA();
        ClassB refB = new ClassB();
    }
}

class ClassA
{
    public ClassA()
    {
        this(10);
        System.out.println("tomato");
    }

    public ClassA(int pValue)
    {
        System.out.println("banana");
    }
}

class ClassB extends ClassA {
    public ClassB() {
        super(0);
        System.out.println("apple");
    }
}


/*
Predict output here:
banana
tomato
banana
apple
*/