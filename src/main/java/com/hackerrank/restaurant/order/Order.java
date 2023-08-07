package com.hackerrank.restaurant.order;

import com.hackerrank.restaurant.exceptions.BadQuantityException;
import com.hackerrank.restaurant.exceptions.DuplicateItemEntryException;
import com.hackerrank.restaurant.exceptions.NoSuchItemException;
import com.hackerrank.restaurant.exceptions.NotEnoughItemException;
import com.hackerrank.restaurant.items.Item;
import java.util.HashMap;
import java.util.Map;

public class Order {
    /**
     *
     * The order id
     */
    private final long id;

    /**
     *
     * A map to keep track of all the items in the order and the quantity
     */
    private final Map<Item, Integer> items;

    /**
     *
     * @param id The order id
     */
    public Order(long id) {
        this.id = id;
        this.items = new HashMap<>();
    }

    /**
     *
     * @return The order id
     */
    public long getId() {
        return this.id;
    }

    /**
     *
     * @param item The item to be added in the order
     * @param quantity The added quantity
     * @throws BadQuantityException When the quantity is less than or equal to zero
     * @throws NoSuchItemException When the item is not available
     * @throws NotEnoughItemException When the updated quantity is greater than the quantity in the inventory
     * @throws DuplicateItemEntryException When adding an existing item in the order
     */
    public void addItem(Item item, int quantity) {

    }

    /**
     *
     * @param item The item to be removed from the order
     * @throws NoSuchItemException When the item is not available
     */
    public void removeItem(Item item) {

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
     * @throws NotEnoughItemException When the updated quantity is greater than the quantity in the inventory
     */
    public void incrementQuantity(Item item, int quantity) {

    }

    /**
     *
     * @param item The item in the order
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

    /**
     *
     * @return All the items and added quantity
     */
    public Map<Item, Integer> getItems() {
        return this.items;
    }

    /**
     *
     * @return All the items name, quantity, cost per unit, and total cost
     * separated by space each on a separate line. The items on each line must
     * be in the lexicographical order. For example,
     * <pre>
     * {@code
     * Latte 3 $3.78 $11.34
     * Mulled Cider 2 $3.32 $6.64
     * Spicy Apple Cider 2 $3.21 $6.42
     * }
     * </pre>
     */
    public String printOrder() {
        return "";
    }
}
