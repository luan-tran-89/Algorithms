package com.interview.takecommand;

/**
 * @author gasieugru
 */
public class Sandwich extends Item {

    public Sandwich() {
        this.name = "Sandwich";
        this.time = 180;
        this.temperature = 240;
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
