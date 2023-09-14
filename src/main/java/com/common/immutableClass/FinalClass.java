package com.common.immutableClass;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gasieugru
 */
public final class FinalClass {

    private final int id;

    private final String name;

    private final HashMap<String, String> map;

    public FinalClass(int id, String name, Map<String, String> map) {
        this.id = id;
        this.name = name;

        HashMap<String, String> tmp = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            tmp.put(entry.getKey(), entry.getValue());
        }

        this.map = tmp;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getMap() {
        return (Map<String, String>) map.clone();
    }
}
