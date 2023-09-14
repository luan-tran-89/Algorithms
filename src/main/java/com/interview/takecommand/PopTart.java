package com.interview.takecommand;

/**
 * @author gasieugru
 */
public class PopTart extends Item {

    public PopTart() {
        this.name = "PopTart";
        this.time = 240;
        this.temperature = 320;
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
