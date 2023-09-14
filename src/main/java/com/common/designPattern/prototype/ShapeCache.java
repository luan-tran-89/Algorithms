package com.common.designPattern.prototype;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author gasieugru
 */
public class ShapeCache {
    private static Map<String, Shape> shapeMap = new Hashtable<>();

    public static void loadCache() {
        Circle circle = new Circle("1");
        shapeMap.put(circle.getId(), circle);

        Square square = new Square("2");
        shapeMap.put(square.getId(), square);
    }

    public static Shape getShape(String id) {
        Shape shape = shapeMap.get(id);
        return shape == null ? null : (Shape) shape.clone();
    }

}
