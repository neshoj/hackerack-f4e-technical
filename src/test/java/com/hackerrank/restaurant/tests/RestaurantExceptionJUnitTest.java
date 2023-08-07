package com.hackerrank.restaurant.tests;

import com.hackerrank.restaurant.inventory.Inventory;
import com.hackerrank.restaurant.exceptions.BadQuantityException;
import com.hackerrank.restaurant.exceptions.DuplicateItemEntryException;
import com.hackerrank.restaurant.exceptions.EmptyOrderException;
import com.hackerrank.restaurant.exceptions.NoSuchItemException;
import com.hackerrank.restaurant.exceptions.NoSuchOrderException;
import com.hackerrank.restaurant.exceptions.NotEnoughItemException;
import com.hackerrank.restaurant.items.Item;
import com.hackerrank.restaurant.items.beverages.Coffee;
import com.hackerrank.restaurant.order.Order;
import com.hackerrank.restaurant.order.OrderPayment;
import com.hackerrank.restaurant.order.PlaceOrder;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RestaurantExceptionJUnitTest {

    /**
     *
     * ExpectedException instance to test all the exceptions
     * (refer <code><a href="{@docRoot}/com/hackerrank/restaurant/exceptions/package-summary.html">exceptions</a></code>)
     */
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    /**
     *
     * Remove all the items from the inventory before running the tests
     */
    @Before
    public void setUp() {
        Inventory.inventory.removeAllItems();
    }

    /**
     *
     * It tests for {@link com.hackerrank.restaurant.exceptions.BadQuantityException}
     * when adding items in the inventory
     */
    @Test
    public void badQuantityExceptionForInventoryAddItem() {
        thrown.expect(BadQuantityException.class);

        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(mocha, 0);
    }

    /**
     *
     * It tests for {@link com.hackerrank.restaurant.exceptions.BadQuantityException}
     * when incrementing quantity of the items in the inventory
     */
    @Test
    public void badQuantityExceptionForInventoryIncrementQuantity() {
        thrown.expect(BadQuantityException.class);

        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(mocha, 1);
        Inventory.inventory.incrementQuantity(mocha, 0);
    }

    /**
     *
     * It tests for {@link com.hackerrank.restaurant.exceptions.BadQuantityException}
     * when decrementing quantity of the items in the inventory
     */
    @Test
    public void badQuantityExceptionForInventoryDecrementQuantity() {
        thrown.expect(BadQuantityException.class);

        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(mocha, 1);
        Inventory.inventory.decrementQuantity(mocha, -1);
    }

    /**
     *
     * It tests for {@link com.hackerrank.restaurant.exceptions.BadQuantityException}
     * when adding items in the order
     */
    @Test
    public void badQuantityExceptionForOrderAddItem() {
        thrown.expect(BadQuantityException.class);

        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(mocha, 1);

        Order order = new Order(1);

        order.addItem(mocha, 0);
    }

    /**
     *
     * It tests for {@link com.hackerrank.restaurant.exceptions.BadQuantityException}
     * when incrementing quantity of the items in the order
     */
    @Test
    public void badQuantityExceptionForOrderIncrementQuantity() {
        thrown.expect(BadQuantityException.class);

        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(mocha, 1);

        Order order = new Order(1);

        order.addItem(mocha, 1);
        order.incrementQuantity(mocha, 0);
    }

    /**
     *
     * It tests for {@link com.hackerrank.restaurant.exceptions.BadQuantityException}
     * when decrementing quantity of the items in the inventory
     */
    @Test
    public void badQuantityExceptionForOrderDecrementQuantity() {
        thrown.expect(BadQuantityException.class);

        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(mocha, 1);

        Order order = new Order(1);

        order.addItem(mocha, 1);
        order.decrementQuantity(mocha, -1);
    }

    /**
     *
     * It tests for {@link com.hackerrank.restaurant.exceptions.DuplicateItemEntryException}
     * when adding items in the inventory
     */
    @Test
    public void duplicateItemEntryExceptionForInventoryAddItem() {
        thrown.expect(DuplicateItemEntryException.class);

        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(mocha, 1);
        Inventory.inventory.addItem(mocha, 2);
    }

    /**
     *
     * It tests for {@link com.hackerrank.restaurant.exceptions.DuplicateItemEntryException}
     * when adding items in the order
     */
    @Test
    public void duplicateItemEntryExceptionForOrderAddItem() {
        thrown.expect(DuplicateItemEntryException.class);

        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(mocha, 2);

        Order order = new Order(1);

        order.addItem(mocha, 1);
        order.addItem(mocha, 1);
    }

    /**
     *
     * It tests for {@link com.hackerrank.restaurant.exceptions.EmptyOrderException}
     * when placing orders
     */
    @Test
    public void emptyOrderExceptionForPlaceOrder() {
        thrown.expect(EmptyOrderException.class);

        Order order = new Order(1);

        PlaceOrder.placeOrder.placeOrder(1, order);
    }

    /**
     *
     * It tests for {@link com.hackerrank.restaurant.exceptions.NoSuchItemException}
     * when removing items from the inventory
     */
    @Test
    public void noSuchItemExceptionForInventoryRemoveItem() {
        thrown.expect(NoSuchItemException.class);

        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.removeItem(mocha);
    }

    /**
     *
     * It tests for {@link com.hackerrank.restaurant.exceptions.NoSuchItemException}
     * when incrementing quantity of the items in the inventory
     */
    @Test
    public void noSuchItemExceptionForInventoryIncrementQuantity() {
        thrown.expect(NoSuchItemException.class);

        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.incrementQuantity(mocha, 1);
    }

    /**
     *
     * It tests for {@link com.hackerrank.restaurant.exceptions.NoSuchItemException}
     * when decrementing quantity of the items in the inventory
     */
    @Test
    public void noSuchItemExceptionForInventoryDecrementQuantity() {
        thrown.expect(NoSuchItemException.class);

        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.decrementQuantity(mocha, 1);
    }

    /**
     *
     * It tests for {@link com.hackerrank.restaurant.exceptions.NoSuchItemException}
     * when adding items in the order
     */
    @Test
    public void noSuchItemExceptionForOrderAddItem() {
        thrown.expect(NoSuchItemException.class);

        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(mocha, 1);

        Order order = new Order(1);

        order.addItem(mocha, 1);
        order.addItem(mocha, 1);
    }

    /**
     *
     * It tests for {@link com.hackerrank.restaurant.exceptions.NoSuchItemException}
     * when removing items from the order
     */
    @Test
    public void noSuchItemExceptionForOrderRemoveItem() {
        thrown.expect(NoSuchItemException.class);

        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(mocha, 1);

        Order order = new Order(1);

        order.removeItem(mocha);
    }

    /**
     *
     * It tests for {@link com.hackerrank.restaurant.exceptions.NoSuchItemException}
     * when incrementing quantity of the items in the order
     */
    @Test
    public void noSuchItemExceptionForOrderIncrementQuantity() {
        thrown.expect(NoSuchItemException.class);

        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(mocha, 1);

        Order order = new Order(1);

        order.incrementQuantity(mocha, 1);
    }

    /**
     *
     * It tests for {@link com.hackerrank.restaurant.exceptions.NoSuchItemException}
     * when decrementing quantity of the items in the order
     */
    @Test
    public void noSuchItemExceptionForOrderDecrementQuantity() {
        thrown.expect(NoSuchItemException.class);

        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(mocha, 1);

        Order order = new Order(1);

        order.decrementQuantity(mocha, 1);
    }

    /**
     *
     * It tests for {@link com.hackerrank.restaurant.exceptions.NoSuchOrderException}
     * when making payments for orders
     */
    @Test
    public void noSuchOrderExceptionForOrderPayment() {
        thrown.expect(NoSuchOrderException.class);

        new OrderPayment(1, 1).getPayableAmount();
    }

    /**
     *
     * It tests for {@link com.hackerrank.restaurant.exceptions.NotEnoughItemException}
     * when decrementing quantity of the items in the inventory
     */
    @Test
    public void notEnoughItemExceptionForInventoryDecrementQuantity() {
        thrown.expect(NotEnoughItemException.class);

        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(mocha, 1);
        Inventory.inventory.decrementQuantity(mocha, 2);
    }

    /**
     *
     * It tests for {@link com.hackerrank.restaurant.exceptions.NotEnoughItemException}
     * when adding items in the order
     */
    @Test
    public void notEnoughItemExceptionForOrderAddItem() {
        thrown.expect(NotEnoughItemException.class);

        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(mocha, 1);

        Order order = new Order(1);

        order.addItem(mocha, 2);
    }

    /**
     *
     * It tests for {@link com.hackerrank.restaurant.exceptions.NotEnoughItemException}
     * when incrementing quantity of the items in the order
     */
    @Test
    public void notEnoughItemExceptionForOrderIncrementQuantity() {
        thrown.expect(NotEnoughItemException.class);

        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(mocha, 1);

        Order order = new Order(1);

        order.addItem(mocha, 1);
        order.incrementQuantity(mocha, 1);
    }

    /**
     *
     * It tests for {@link com.hackerrank.restaurant.exceptions.NotEnoughItemException}
     * when decrementing quantity of the items in the order
     */
    @Test
    public void notEnoughItemExceptionForOrderDecrementQuantity() {
        thrown.expect(NotEnoughItemException.class);

        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(mocha, 1);

        Order order = new Order(1);

        order.addItem(mocha, 1);
        order.decrementQuantity(mocha, 2);
    }
}
