package com.common.designPattern.prototype;

/**
 * @author gasieugru
 */
public class Circle extends Shape {

    public Circle(String id) {
        super(id, "Circle");
    }

    @Override
    void draw() {
        System.out.println("Drawing Circle");
    }
}
