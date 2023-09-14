package com.interview.takecommand;

/**
 * @author gasieugru
 */
public class Main {

    public static void main(String[] args) {
        Toaster toaster = new Toaster(4);
        toaster.addItem(1, "Bagel");
        toaster.addItem(2, "Sandwich");
        toaster.addItem(3, "PopTart");
        toaster.addCustomItem(4, 280, 400);

        toaster.startAll();
        System.out.println(toaster);

        toaster.stopAtPosition(1);
        System.out.println(toaster);

        toaster.printSlotStatus();
    }

}
