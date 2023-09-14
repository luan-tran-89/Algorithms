package com.coding;

/**
 * @author gasieugru
 */
public class Student extends Person {

    @Override
    protected void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Student student = new Student();


        System.out.println("dsdsa");
    }
}
