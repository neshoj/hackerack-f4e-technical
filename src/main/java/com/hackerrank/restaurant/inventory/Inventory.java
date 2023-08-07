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
     * Inventory static instance to access the inventory
     */
    public static final Inventory inventory = new Inventory();

    /**
     * A map to keep track of all the items and the quantity
     */
    private final Map<Item, Integer> itemsCount;

    /**
     * Initializes the items count map
     */
    public Inventory() {
        this.itemsCount = new HashMap<>();
    }

    /**
     * @param item     The item to be added in the inventory
     * @param quantity The added quantity
     * @throws BadQuantityException        When the quantity is less than or equal to zero
     * @throws DuplicateItemEntryException When adding an existing item in the inventory
     */
    public void addItem(Item item, int quantity) {
        if (quantity < 0) {
            throw new BadQuantityException("Expecting a value greater than zero but -1 found.");
        }
        if (quantity == 0) {
            throw new BadQuantityException("Expecting a value greater than zero but 0 found.");
        }
        Integer itemExists = this.itemsCount.get(item);
        if (itemExists != null) {
            throw new DuplicateItemEntryException(String.format("Cannot add duplicate item '%s'.", item.getName()));
        }

        this.itemsCount.put(item, quantity);
    }

    /**
     * @param item The item to be removed from the inventory
     * @throws NoSuchItemException When the item is not available
     */
    public void removeItem(Item item) {
        Integer itemToBeRemoved = this.itemsCount.get(item);
        if (itemToBeRemoved == null) {
            throw new NoSuchItemException(String.format("Item '%s' is not available.", item.getName()));
        }
        this.itemsCount.remove(item);
    }

    /**
     * Remove all the items in the inventory
     */
    public void removeAllItems() {
        this.itemsCount.clear();
    }

    /**
     * @return List of all the items in the inventory
     */
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        this.itemsCount.forEach((item, integer) -> items.add(item));
        return items;
    }

    /**
     * @param item The item in the inventory
     * @return The quantity of the item
     */
    public int getQuantity(Item item) {
        Integer quantity = this.itemsCount.get(item);
        if(quantity == null){
            return 0;
        }
        return quantity;
    }

    /**
     * @param item     The item in the order
     * @param quantity The expected quantity of the increment
     *                 <pre>
     *                                                                                 {@code updatedQuantity = currentQuantity + quantity;}
     *                                                                                 </pre>
     * @throws BadQuantityException When the quantity is less than or equal to zero
     * @throws NoSuchItemException  When the item is not available
     */
    public void incrementQuantity(Item item, int quantity) {
        if (quantity < 0) {
            throw new BadQuantityException("Expecting a value greater than zero but -1 found.");
        }
        if (quantity == 0) {
            throw new BadQuantityException("Expecting a value greater than zero but 0 found.");
        }
        Integer oldQuantity = this.itemsCount.get(item);
        if (oldQuantity == null) {
            throw new NoSuchItemException("Item '"+item.getName()+"' is not available.");
        }

        Integer newQuantity = oldQuantity + quantity;


        this.itemsCount.put(item, newQuantity);
    }

    /**
     * @param item     The item in the inventory
     * @param quantity The expected quantity of the decrement
     *                 <pre>
     *                                                                                 {@code updatedQuantity = currentQuantity - quantity;}
     *                                                                                 </pre>
     * @throws BadQuantityException   When the quantity is less than or equal to zero
     * @throws NoSuchItemException    When the item is not available
     * @throws NotEnoughItemException When the updated quantity is less than zero
     */
    public void decrementQuantity(Item item, int quantity) {
        if (quantity < 0) {
            throw new BadQuantityException("Expecting a value greater than zero but -1 found.");
        }
        if (quantity == 0) {
            throw new BadQuantityException("Expecting a value greater than zero but 0 found.");
        }

        Integer oldQuantity = this.itemsCount.get(item);
        if (oldQuantity == null) {
            throw new NoSuchItemException("Item '"+item.getName()+"' is not available.");
        }

        int newQuantity = oldQuantity - quantity;
        if (newQuantity < 0) {
            throw new NotEnoughItemException("Not enough quantity for the item '"+item.getName()+"'.");
        }
        this.itemsCount.put(item, newQuantity);
    }
}
