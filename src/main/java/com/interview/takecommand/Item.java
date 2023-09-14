package com.interview.takecommand;

/**
 * @author gasieugru
 */
public abstract class Item {

    protected String name;

    protected int time;

    protected int temperature;

    protected String status;

    public Item() {
        this.status = "STOP";
    }

    public abstract int getTime();

    public abstract int getTemperature();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", temperature=" + temperature +
                ", status='" + status + '\'' +
                '}';
    }
}
