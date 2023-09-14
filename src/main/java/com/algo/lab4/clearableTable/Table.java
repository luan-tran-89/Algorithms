package com.algo.lab4.clearableTable;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author gasieugru
 */
public class Table<T> {

    private T[] table;
    private int index;

    public Table(Class<T> clazz, int capacity) {
        table = (T[]) Array.newInstance(clazz, capacity);
        index = 0;
    }

    public void add(T x) {
        table[index++] = x;
    }

    public void clear() {
        if (index > 0) {
            for (int i = 0; i < index; i++) {
                table[i] = null;
            }
            index = 0;
        }
    }

    @Override
    public String toString() {
        return String.format("Table: %s", Arrays.toString(table));
    }

    public static void main(String[] args) {
        Table<Integer> table = new Table(Integer.class, 10);
        table.add(5);
        table.add(3);
        table.add(1);
        // Table: [5, 3, 1, null, null, null, null, null, null, null]
        System.out.println(table);
        table.clear();
        // Table: [null, null, null, null, null, null, null, null, null, null]
        System.out.println(table);
    }

}
