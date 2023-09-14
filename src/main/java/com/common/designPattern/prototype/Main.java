package com.common.designPattern.prototype;

/**
 * @author gasieugru
 */
public class Main {

    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape cloneShape = ShapeCache.getShape("1");
        System.out.println(cloneShape.getType());

        Shape cloneShape1 = ShapeCache.getShape("2");
        System.out.println(cloneShape1.getType());
    }

}
