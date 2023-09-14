package com.interview.takecommand;

/**
 * @author gasieugru
 */
public class CustomItem extends Item {

    public CustomItem(int time, int temperature) {
        this.name = "Custom Item";
        this.time = time;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getTime() {
        return this.time;
    }

    @Override
    public int getTemperature() {
        return this.temperature;
    }
}
