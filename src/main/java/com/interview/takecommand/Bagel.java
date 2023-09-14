package com.interview.takecommand;

/**
 * @author gasieugru
 */
public class Bagel extends Item {

    public Bagel() {
        this.name = "Bagel";
        this.time = 120;
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
