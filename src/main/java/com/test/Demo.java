package com.test;
import java.util.*;

/**
 * @author gasieugru
 */
public class Demo {

    public String test;

    public static void main(String... arrrrrgs) {
        Properties p = System.getProperties();
        p.setProperty ("pirate", "scurvy");
        String s = p.getProperty("argProp") + " ";
        s += p.getProperty ("pirate");
        System.out.println (s);

        int x = 1;
        for (int i = 1; i <= 128; i += i) {
            x += x;
        }
        // 1 2 4 8 16 32 64 128
        // 2 4 8 16 32 64 128 256
        System.out.println(x);

        double d = 10.0 / -0;
        System.out.println(d == Double.POSITIVE_INFINITY);

        System.out.println(3 & 5);
        System.out.println(3 | 5);

        PriorityQueue toDo = new PriorityQueue();
        toDo.add("dishes");
        toDo.add("laundry");
        toDo.add("bills");
        toDo.offer("bills");
        // 3 bills
        System.out.print(toDo.size() + " " + toDo.poll());
        // bills bills
        System.out.print(" " + toDo.peek() + " " + toDo.poll());
        // dishes laundry
        System.out.print(" " + toDo.poll() + " " + toDo.poll());
    }
}
