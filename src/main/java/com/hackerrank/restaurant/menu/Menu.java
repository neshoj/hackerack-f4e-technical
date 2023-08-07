package com.hackerrank.restaurant.menu;

import com.hackerrank.restaurant.items.Item;

public class Menu {

    /**
     *
     * Menu static instance to access the menu
     */
    public static final Menu menu = new Menu();

    /**
     *
     * @param item The item to check the availability for
     * @return Whether the item is available or not
     */
    public boolean isItemAvailable(Item item) {
        return true;
    }

    /**
     *
     * @return All the items name in the lexicographical order separated by
     * a comma followed by a space. For example,
     * <pre>
     * {@code Cappuccino, Chai, Latte, Mocha}
     * </pre>
     */
    public String displayItems() {
        return "";
    }
}
