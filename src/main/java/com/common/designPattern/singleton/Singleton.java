package com.common.designPattern.singleton;

/**
 * @author gasieugru
 */
public class Singleton {
    private static Singleton INSTANCE;

    private Singleton() {

    }

    public static synchronized Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

    public static synchronized Singleton getInstance1() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }

        return INSTANCE;
    }

}
