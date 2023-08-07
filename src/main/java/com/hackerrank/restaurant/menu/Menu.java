package com.hackerrank.restaurant.menu;

import com.hackerrank.restaurant.inventory.Inventory;
import com.hackerrank.restaurant.items.Item;

import java.util.Comparator;
import java.util.List;

public class Menu extends Inventory {

    /**
     * Menu static instance to access the menu
     */
    public static final Menu menu = new Menu();


    /**
     * @param item The item to check the availability for
     * @return Whether the item is available or not
     */
    public boolean isItemAvailable(Item item) {
        int quantity = Inventory.inventory.getQuantity(item);
        return quantity > 0;
    }

    /**
     * @return All the items name in the lexicographical order separated by
     * a comma followed by a space. For example,
     * <pre>
     * {@code Cappuccino, Chai, Latte, Mocha}
     * </pre>
     */
    public String displayItems() {
        List<Item> items = Inventory.inventory.getItems();
        Comparator<Item> itemNameComparator = Comparator.comparing(Item::getName);

        items.sort(itemNameComparator);
        StringBuilder names = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            if (isItemAvailable(items.get(i))) {
                names.append(items.get(i).getName());
                if ((i + 1) < items.size()) {
                    names.append(", ");
                }
            }
        }
        return names.toString();
    }
}
