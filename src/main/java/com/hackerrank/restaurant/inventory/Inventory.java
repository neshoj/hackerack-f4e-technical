package com.hackerrank.restaurant.inventory;

import com.hackerrank.restaurant.exceptions.BadQuantityException;
import com.hackerrank.restaurant.exceptions.DuplicateItemEntryException;
import com.hackerrank.restaurant.exceptions.NoSuchItemException;
import com.hackerrank.restaurant.exceptions.NotEnoughItemException;
import com.hackerrank.restaurant.items.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {

    /**
     *
     * Inventory static instance to access the inventory
     */
    public static final Inventory inventory = new Inventory();

    /**
     *
     * A map to keep track of all the items and the quantity
     */
    private final Map<Item, Integer> itemsCount;

    /**
     *
     * Initializes the items count map
     */
    public Inventory() {
        this.itemsCount = new HashMap<>();
    }

    /**
     *
     * @param item The item to be added in the inventory
     * @param quantity The added quantity
     * @throws BadQuantityException When the quantity is less than or equal to zero
     * @throws DuplicateItemEntryException When adding an existing item in the inventory
     */
    public void addItem(Item item, int quantity) {

    }

    /**
     *
     * @param item The item to be removed from the inventory
     * @throws NoSuchItemException When the item is not available
     */
    public void removeItem(Item item) {

    }

    /**
     *
     * Remove all the items in the inventory
     */
    public void removeAllItems() {

    }

    /**
     *
     * @return List of all the items in the inventory
     */
    public List<Item> getItems() {
        return new ArrayList<>();
    }

    /**
     *
     * @param item The item in the inventory
     * @return The quantity of the item
     */
    public int getQuantity(Item item) {
        return 0;
    }

    /**
     *
     * @param item The item in the order
     * @param quantity The expected quantity of the increment
     * <pre>
     * {@code updatedQuantity = currentQuantity + quantity;}
     * </pre>
     * @throws BadQuantityException When the quantity is less than or equal to zero
     * @throws NoSuchItemException When the item is not available
     */
    public void incrementQuantity(Item item, int quantity) {

    }

    /**
     *
     * @param item The item in the inventory
     * @param quantity The expected quantity of the decrement
     * <pre>
     * {@code updatedQuantity = currentQuantity - quantity;}
     * </pre>
     * @throws BadQuantityException When the quantity is less than or equal to zero
     * @throws NoSuchItemException When the item is not available
     * @throws NotEnoughItemException When the updated quantity is less than zero
     */
    public void decrementQuantity(Item item, int quantity) {

    }
}
