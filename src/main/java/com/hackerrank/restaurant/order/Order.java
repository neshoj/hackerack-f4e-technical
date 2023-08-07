package com.hackerrank.restaurant.order;

import com.hackerrank.restaurant.exceptions.BadQuantityException;
import com.hackerrank.restaurant.exceptions.DuplicateItemEntryException;
import com.hackerrank.restaurant.exceptions.NoSuchItemException;
import com.hackerrank.restaurant.exceptions.NotEnoughItemException;
import com.hackerrank.restaurant.inventory.Inventory;
import com.hackerrank.restaurant.items.Item;
import com.hackerrank.restaurant.menu.Menu;

import java.util.*;

public class Order extends Menu {
    /**
     * The order id
     */
    private final long id;

    /**
     * A map to keep track of all the items in the order and the quantity
     */
    private final Map<Item, Integer> items;

    /**
     * @param id The order id
     */
    public Order(long id) {
        this.id = id;
        this.items = new HashMap<>();
    }

    /**
     * @return The order id
     */
    public long getId() {
        return this.id;
    }

    /**
     * @param item     The item to be added in the order
     * @param quantity The added quantity
     * @throws BadQuantityException        When the quantity is less than or equal to zero
     * @throws NoSuchItemException         When the item is not available
     * @throws NotEnoughItemException      When the updated quantity is greater than the quantity in the inventory
     * @throws DuplicateItemEntryException When adding an existing item in the order
     */

    @Override
    public void addItem(Item item, int quantity) {
        if (quantity < 0) {
            throw new BadQuantityException(quantity < 0 ? "Expecting a value greater than zero but -1 found." : "Expecting a value greater than zero but 0 found.");
        }
        int inventory = this.getQuantity(item);
        if (quantity > inventory) {
            throw new NoSuchItemException("Item '" + item.getName() + "' is not available.");
        }
        this.items.put(item, quantity);
    }

    /**
     * @param item The item to be removed from the order
     * @throws NoSuchItemException When the item is not available
     */
    public void removeItem(Item item) {
        Integer itemToBeRemoved = this.items.get(item);
        if (itemToBeRemoved == null) {
            throw new NoSuchItemException(String.format("Item '%s' is not available.", item.getName()));
        }
        this.items.remove(item);
    }

    /**
     * @param item     The item in the order
     * @param quantity The expected quantity of the increment
     *                 <pre>
     *                                 {@code updatedQuantity = currentQuantity + quantity;}
     *                                 </pre>
     * @throws BadQuantityException   When the quantity is less than or equal to zero
     * @throws NoSuchItemException    When the item is not available
     * @throws NotEnoughItemException When the updated quantity is greater than the quantity in the inventory
     */
    public void incrementQuantity(Item item, int quantity) {
        if (quantity < 0) {
            throw new BadQuantityException("Expecting a value greater than zero but -1 found.");
        }
        if (quantity == 0) {
            throw new BadQuantityException("Expecting a value greater than zero but 0 found.");
        }
        Integer oldQuantity = this.items.get(item);
        if (oldQuantity == null) {
            throw new NoSuchItemException("Item '" + item.getName() + "' is not available.");
        }
        Integer newQuantity = oldQuantity + quantity;
        this.items.put(item, newQuantity);
    }

    /**
     * @param item     The item in the order
     * @param quantity The expected quantity of the decrement
     *                 <pre>
     *                                 {@code updatedQuantity = currentQuantity - quantity;}
     *                                 </pre>
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

        Integer oldQuantity = this.items.get(item);
        if (oldQuantity == null) {
            throw new NoSuchItemException("Item '" + item.getName() + "' is not available.");
        }

        int newQuantity = oldQuantity - quantity;
        if (newQuantity < 0) {
            throw new NotEnoughItemException("Not enough quantity for the item '" + item.getName() + "'.");
        }
        this.items.put(item, newQuantity);
    }

    /**
     * @return All the items and added quantity
     */
    @Override
    public List<Item> getItems() {
        return (List<Item>) this.items;
    }

    /**
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
        Comparator<Item> itemNameComparator = Comparator.comparing(Item::getName);
        this.getItems().sort(itemNameComparator);
        StringBuilder names = new StringBuilder();

        Iterator<Map.Entry<Item, Integer>> iterator = items.entrySet().iterator();

        while (iterator.hasNext()) {

            Map.Entry<Item, Integer> next = iterator.next();
            Item value = next.getKey();
            Integer value1 = next.getValue();
            names.append(value.getName() + " " + value1 + " $" + value.getCost() + " $" + (value.getCost() * value1));
            if (iterator.hasNext()) {
                names.append("\n");
            }
        }
        return names.toString();
    }
}
