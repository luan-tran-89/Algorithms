package com.interview.takecommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gasieugru
 */
public class Toaster implements ToasterAction {

    Map<Integer, Item> items = new HashMap();

    public Toaster(int numberSlot) {
        for (int i = 0; i < numberSlot; i++) {
            items.put(i + 1, null);
        }
    }

    public void addItem(int position, String itemType) {
        if (position > items.size()) {
            throw new IllegalArgumentException("The Toaster only have " + items.size() + " slots.");
        }
        Item item = ItemFactory.getInstanse().getItem(itemType);
        items.put(position, item);
    }

    public void addCustomItem(int position, int time, int temperature) {
        if (position > items.size()) {
            throw new IllegalArgumentException("The Toaster only have " + items.size() + " slots.");
        }
        Item item = ItemFactory.getInstanse().getCustomItem(time, temperature);
        items.put(position, item);
    }

    @Override
    public void startAll() {
        this.items.values().forEach(item -> item.setStatus("START"));
    }

    @Override
    public void startAtPosition(int position) {
        Item item = this.items.get(position);
        if (item != null) {
            item.setStatus("START");
        }
    }

    @Override
    public void stopAll() {
        this.items.values().forEach(item -> item.setStatus("STOP"));
    }

    @Override
    public void stopAtPosition(int position) {
        Item item = this.items.get(position);
        if (item != null) {
            item.setStatus("STOP");
        }
    }

    @Override
    public void printSlotStatus() {
        this.items.entrySet().forEach(entry -> {
            System.out.printf("Slot %s - %s\n", entry.getKey(), entry.getValue().status);
        });
    }

    @Override
    public String toString() {
        return "Toaster{" +
                "numberSlot=" + items.size() +
                ", items=" + items +
                '}';
    }
}
