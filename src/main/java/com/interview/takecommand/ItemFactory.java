package com.interview.takecommand;

/**
 * @author gasieugru
 */
public class ItemFactory {
    private static ItemFactory INSTANCE;

    private ItemFactory() {

    }

    public static synchronized ItemFactory getInstanse() {
        if (INSTANCE == null) {
            INSTANCE = new ItemFactory();
        }
        return INSTANCE;
    }

    public Item getItem(String type) {
        switch (type) {
            case "Bagel":
                return new Bagel();
            case "Sandwich":
                return new Sandwich();
            case "PopTart":
                return new PopTart();
            default:
                System.out.println("Don't support this type: " + type);
                return null;
        }
    }

    public Item getCustomItem(int time, int temperature) {
        return new CustomItem(time, temperature);
    }
}
