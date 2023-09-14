package com.common.designPattern.prototype;

/**
 * @author gasieugru
 */
public class Square extends Shape {

    public Square(String id) {
        super(id, "Square");
    }

    @Override
    void draw() {
        System.out.println("Drawing Square");
    }
}
