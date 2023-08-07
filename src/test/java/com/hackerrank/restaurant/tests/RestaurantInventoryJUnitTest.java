package com.hackerrank.restaurant.tests;

import com.hackerrank.restaurant.inventory.Inventory;
import com.hackerrank.restaurant.exceptions.BadQuantityException;
import com.hackerrank.restaurant.exceptions.DuplicateItemEntryException;
import com.hackerrank.restaurant.exceptions.NoSuchItemException;
import com.hackerrank.restaurant.exceptions.NotEnoughItemException;
import com.hackerrank.restaurant.items.Item;
import com.hackerrank.restaurant.items.beverages.Coffee;
import com.hackerrank.restaurant.menu.Menu;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RestaurantInventoryJUnitTest {

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
     * It tests for adding items in the inventory and
     * validating the items displayed on the menu
     * (refer {@link com.hackerrank.restaurant.menu.Menu#displayItems()})
     */
    @Test
    public void addItemAndValidateMenu() {
        Item cappuccino = new Coffee("Cappuccino", 3.58);
        Item chai = new Coffee("Chai", 3.71);
        Item latte = new Coffee("Latte", 3.78);
        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(cappuccino, 1);
        Inventory.inventory.addItem(chai, 2);
        Inventory.inventory.addItem(latte, 3);
        Inventory.inventory.addItem(mocha, 4);

        assertThat(Menu.menu.displayItems(), is("Cappuccino, Chai, Latte, Mocha"));
    }

    /**
     *
     * It tests for adding items in the inventory and
     * validating the quantity of added items
     */
    @Test
    public void addItemAndValidateQuantity() {
        Item cappuccino = new Coffee("Cappuccino", 3.58);
        Item chai = new Coffee("Chai", 3.71);
        Item latte = new Coffee("Latte", 3.78);
        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(cappuccino, 1);
        Inventory.inventory.addItem(chai, 2);
        Inventory.inventory.addItem(latte, 3);
        Inventory.inventory.addItem(mocha, 4);

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(1));
        assertThat(Inventory.inventory.getQuantity(chai), is(2));
        assertThat(Inventory.inventory.getQuantity(latte), is(3));
        assertThat(Inventory.inventory.getQuantity(mocha), is(4));
    }

    /**
     *
     * It tests for adding duplicate items in the inventory and
     * validating the items displayed on the menu
     * (refer {@link com.hackerrank.restaurant.menu.Menu#displayItems()})
     */
    @Test
    public void addDuplicateItemAndValidateMenu() {
        Item cappuccino = new Coffee("Cappuccino", 3.58);
        Item chai = new Coffee("Chai", 3.71);
        Item latte = new Coffee("Latte", 3.78);
        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(cappuccino, 1);
        Inventory.inventory.addItem(chai, 2);
        Inventory.inventory.addItem(latte, 3);
        Inventory.inventory.addItem(mocha, 4);

        assertThat(Menu.menu.displayItems(), is("Cappuccino, Chai, Latte, Mocha"));

        String exceptionMessage = "";

        try {
            Inventory.inventory.addItem(latte, 1);
        } catch (DuplicateItemEntryException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Cannot add duplicate item 'Latte'."));

        assertTrue(Menu.menu.displayItems().equals("Cappuccino, Chai, Latte, Mocha"));
    }

    /**
     *
     * It tests for adding duplicate items in the inventory and
     * validating the quantity of added items
     */
    @Test
    public void addDuplicateItemAndValidateQuantity() {
        Item cappuccino = new Coffee("Cappuccino", 3.58);
        Item chai = new Coffee("Chai", 3.71);
        Item latte = new Coffee("Latte", 3.78);
        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(cappuccino, 1);
        Inventory.inventory.addItem(chai, 2);
        Inventory.inventory.addItem(latte, 3);
        Inventory.inventory.addItem(mocha, 4);

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(1));
        assertThat(Inventory.inventory.getQuantity(chai), is(2));
        assertThat(Inventory.inventory.getQuantity(latte), is(3));
        assertThat(Inventory.inventory.getQuantity(mocha), is(4));

        String exceptionMessage = "";

        try {
            Inventory.inventory.addItem(latte, 1);
        } catch (DuplicateItemEntryException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Cannot add duplicate item 'Latte'."));

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(1));
        assertThat(Inventory.inventory.getQuantity(chai), is(2));
        assertThat(Inventory.inventory.getQuantity(latte), is(3));
        assertThat(Inventory.inventory.getQuantity(mocha), is(4));
    }

    /**
     *
     * It tests for adding items with bad quantity i.e.,
     * the value of the quantity is less than or equal to zero,
     * in the inventory and validating the items displayed on the menu
     * (refer {@link com.hackerrank.restaurant.menu.Menu#displayItems()})
     */
    @Test
    public void addItemWithBadQuantityAndValidateMenu() {
        Item cappuccino = new Coffee("Cappuccino", 3.58);
        Item chai = new Coffee("Chai", 3.71);
        Item latte = new Coffee("Latte", 3.78);
        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(cappuccino, 1);
        Inventory.inventory.addItem(chai, 2);

        assertThat(Menu.menu.displayItems(), is("Cappuccino, Chai"));

        String exceptionMessage = "";

        try {
            Inventory.inventory.addItem(latte, 0);
        } catch (BadQuantityException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Expecting a value greater than zero but 0 found."));

        assertThat(Menu.menu.displayItems(), is("Cappuccino, Chai"));

        try {
            Inventory.inventory.addItem(mocha, -1);
        } catch (BadQuantityException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Expecting a value greater than zero but -1 found."));

        assertThat(Menu.menu.displayItems(), is("Cappuccino, Chai"));
    }

    /**
     *
     * It tests for adding items with bad quantity i.e.,
     * the value of the quantity is less than or equal to zero,
     * in the inventory and validating the quantity of added items
     */
    @Test
    public void addItemWithBadQuantityAndValidateQuantity() {
        Item cappuccino = new Coffee("Cappuccino", 3.58);
        Item chai = new Coffee("Chai", 3.71);
        Item latte = new Coffee("Latte", 3.78);
        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(cappuccino, 1);
        Inventory.inventory.addItem(chai, 2);

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(1));
        assertThat(Inventory.inventory.getQuantity(chai), is(2));
        assertThat(Inventory.inventory.getQuantity(latte), is(0));
        assertThat(Inventory.inventory.getQuantity(mocha), is(0));

        String exceptionMessage = "";

        try {
            Inventory.inventory.addItem(latte, 0);
        } catch (BadQuantityException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Expecting a value greater than zero but 0 found."));

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(1));
        assertThat(Inventory.inventory.getQuantity(chai), is(2));
        assertThat(Inventory.inventory.getQuantity(latte), is(0));
        assertThat(Inventory.inventory.getQuantity(mocha), is(0));

        try {
            Inventory.inventory.addItem(mocha, -1);
        } catch (BadQuantityException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Expecting a value greater than zero but -1 found."));

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(1));
        assertThat(Inventory.inventory.getQuantity(chai), is(2));
        assertThat(Inventory.inventory.getQuantity(latte), is(0));
        assertThat(Inventory.inventory.getQuantity(mocha), is(0));
    }

    /**
     *
     * It tests for incrementing and decrementing the quantity of items
     * in the inventory and validating the items displayed on the menu
     * (refer {@link com.hackerrank.restaurant.menu.Menu#displayItems()})
     */
    @Test
    public void addItemAndIncrementDecrementQuantityAndValidateMenuAndValidateQuantity() {
        Item cappuccino = new Coffee("Cappuccino", 3.58);
        Item chai = new Coffee("Chai", 3.71);
        Item latte = new Coffee("Latte", 3.78);
        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(cappuccino, 1);
        Inventory.inventory.addItem(chai, 2);
        Inventory.inventory.addItem(latte, 3);
        Inventory.inventory.addItem(mocha, 4);

        assertThat(Menu.menu.displayItems(), is("Cappuccino, Chai, Latte, Mocha"));

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(1));
        assertThat(Inventory.inventory.getQuantity(chai), is(2));
        assertThat(Inventory.inventory.getQuantity(latte), is(3));
        assertThat(Inventory.inventory.getQuantity(mocha), is(4));

        Inventory.inventory.incrementQuantity(cappuccino, 1);
        Inventory.inventory.incrementQuantity(chai, 1);
        Inventory.inventory.incrementQuantity(latte, 1);
        Inventory.inventory.incrementQuantity(mocha, 1);

        assertThat(Menu.menu.displayItems(), is("Cappuccino, Chai, Latte, Mocha"));

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(2));
        assertThat(Inventory.inventory.getQuantity(chai), is(3));
        assertThat(Inventory.inventory.getQuantity(latte), is(4));
        assertThat(Inventory.inventory.getQuantity(mocha), is(5));

        Inventory.inventory.decrementQuantity(cappuccino, 2);
        Inventory.inventory.decrementQuantity(chai, 2);
        Inventory.inventory.decrementQuantity(latte, 2);
        Inventory.inventory.decrementQuantity(mocha, 2);

        assertThat(Menu.menu.displayItems(), is("Chai, Latte, Mocha"));

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(0));
        assertThat(Inventory.inventory.getQuantity(chai), is(1));
        assertThat(Inventory.inventory.getQuantity(latte), is(2));
        assertThat(Inventory.inventory.getQuantity(mocha), is(3));
    }

    /**
     *
     * It tests for incrementing and decrementing the quantity of items
     * in the inventory with bad quantity, i.e.,
     * <ul>
     *      <li>The value of the quantity is less than or equal to zero</li>
     *      <li>The updated value of the quantity is less than or equal to zero</li>
     * </ul>
     * and validating:
     * <ul>
     *      <li>The items displayed on the menu
     * (refer {@link com.hackerrank.restaurant.menu.Menu#displayItems()})</li>
     *      <li>The updated quantity of the added items</li>
     * </ul>
     */
    @Test
    public void addItemAndBadIncrementBadDecrementQuantityAndValidateMenuAndValidateQuantity() {
        Item cappuccino = new Coffee("Cappuccino", 3.58);
        Item chai = new Coffee("Chai", 3.71);
        Item latte = new Coffee("Latte", 3.78);
        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(cappuccino, 1);
        Inventory.inventory.addItem(chai, 2);
        Inventory.inventory.addItem(latte, 3);

        assertThat(Menu.menu.displayItems(), is("Cappuccino, Chai, Latte"));

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(1));
        assertThat(Inventory.inventory.getQuantity(chai), is(2));
        assertThat(Inventory.inventory.getQuantity(latte), is(3));
        assertThat(Inventory.inventory.getQuantity(mocha), is(0));

        Inventory.inventory.incrementQuantity(cappuccino, 1);
        Inventory.inventory.incrementQuantity(chai, 1);
        Inventory.inventory.incrementQuantity(latte, 1);

        String exceptionMessage = "";

        try {
            Inventory.inventory.incrementQuantity(mocha, 1);
        } catch (NoSuchItemException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Item 'Mocha' is not available."));

        assertThat(Menu.menu.displayItems(), is("Cappuccino, Chai, Latte"));

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(2));
        assertThat(Inventory.inventory.getQuantity(chai), is(3));
        assertThat(Inventory.inventory.getQuantity(latte), is(4));
        assertThat(Inventory.inventory.getQuantity(mocha), is(0));

        Inventory.inventory.decrementQuantity(cappuccino, 2);
        Inventory.inventory.decrementQuantity(chai, 2);
        Inventory.inventory.decrementQuantity(latte, 2);

        try {
            Inventory.inventory.decrementQuantity(mocha, 2);
        } catch (NoSuchItemException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Item 'Mocha' is not available."));

        assertThat(Menu.menu.displayItems(), is("Chai, Latte"));

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(0));
        assertThat(Inventory.inventory.getQuantity(chai), is(1));
        assertThat(Inventory.inventory.getQuantity(latte), is(2));
        assertThat(Inventory.inventory.getQuantity(mocha), is(0));

        Inventory.inventory.addItem(mocha, 4);

        assertThat(Menu.menu.displayItems(), is("Chai, Latte, Mocha"));

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(0));
        assertThat(Inventory.inventory.getQuantity(chai), is(1));
        assertThat(Inventory.inventory.getQuantity(latte), is(2));
        assertThat(Inventory.inventory.getQuantity(mocha), is(4));

        Inventory.inventory.incrementQuantity(mocha, 1);

        assertThat(Menu.menu.displayItems(), is("Chai, Latte, Mocha"));

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(0));
        assertThat(Inventory.inventory.getQuantity(chai), is(1));
        assertThat(Inventory.inventory.getQuantity(latte), is(2));
        assertThat(Inventory.inventory.getQuantity(mocha), is(5));

        Inventory.inventory.decrementQuantity(mocha, 2);

        assertThat(Menu.menu.displayItems(), is("Chai, Latte, Mocha"));

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(0));
        assertThat(Inventory.inventory.getQuantity(chai), is(1));
        assertThat(Inventory.inventory.getQuantity(latte), is(2));
        assertThat(Inventory.inventory.getQuantity(mocha), is(3));

        try {
            Inventory.inventory.incrementQuantity(cappuccino, 0);
        } catch (BadQuantityException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Expecting a value greater than zero but 0 found."));

        assertThat(Menu.menu.displayItems(), is("Chai, Latte, Mocha"));

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(0));
        assertThat(Inventory.inventory.getQuantity(chai), is(1));
        assertThat(Inventory.inventory.getQuantity(latte), is(2));
        assertThat(Inventory.inventory.getQuantity(mocha), is(3));

        try {
            Inventory.inventory.decrementQuantity(mocha, 0);
        } catch (BadQuantityException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Expecting a value greater than zero but 0 found."));

        assertThat(Menu.menu.displayItems(), is("Chai, Latte, Mocha"));

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(0));
        assertThat(Inventory.inventory.getQuantity(chai), is(1));
        assertThat(Inventory.inventory.getQuantity(latte), is(2));
        assertThat(Inventory.inventory.getQuantity(mocha), is(3));

        try {
            Inventory.inventory.decrementQuantity(mocha, 4);
        } catch (NotEnoughItemException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Not enough quantity for the item 'Mocha'."));

        assertThat(Menu.menu.displayItems(), is("Chai, Latte, Mocha"));

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(0));
        assertThat(Inventory.inventory.getQuantity(chai), is(1));
        assertThat(Inventory.inventory.getQuantity(latte), is(2));
        assertThat(Inventory.inventory.getQuantity(mocha), is(3));

        Inventory.inventory.decrementQuantity(chai, 1);
        Inventory.inventory.decrementQuantity(latte, 2);
        Inventory.inventory.decrementQuantity(mocha, 3);

        assertThat(Menu.menu.displayItems(), is(""));

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(0));
        assertThat(Inventory.inventory.getQuantity(chai), is(0));
        assertThat(Inventory.inventory.getQuantity(latte), is(0));
        assertThat(Inventory.inventory.getQuantity(mocha), is(0));
    }

    /**
     *
     * It tests for removing items from the inventory and validating the items
     * displayed on the menu
     * (refer {@link com.hackerrank.restaurant.menu.Menu#displayItems()})
     */
    @Test
    public void removeItemAndValidateMenu() {
        Item cappuccino = new Coffee("Cappuccino", 3.58);
        Item chai = new Coffee("Chai", 3.71);
        Item latte = new Coffee("Latte", 3.78);
        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(cappuccino, 1);
        Inventory.inventory.addItem(chai, 2);
        Inventory.inventory.addItem(latte, 3);
        Inventory.inventory.addItem(mocha, 4);

        assertThat(Menu.menu.displayItems(), is("Cappuccino, Chai, Latte, Mocha"));

        Inventory.inventory.removeItem(latte);

        assertThat(Menu.menu.displayItems(), is("Cappuccino, Chai, Mocha"));

        Inventory.inventory.removeItem(cappuccino);

        assertThat(Menu.menu.displayItems(), is("Chai, Mocha"));
    }

    /**
     *
     * It tests for removing items from the inventory and validating the
     * quantity of added items
     */
    @Test
    public void removeItemAndValidateQuantity() {
        Item cappuccino = new Coffee("Cappuccino", 3.58);
        Item chai = new Coffee("Chai", 3.71);
        Item latte = new Coffee("Latte", 3.78);
        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(cappuccino, 1);
        Inventory.inventory.addItem(chai, 2);
        Inventory.inventory.addItem(latte, 3);
        Inventory.inventory.addItem(mocha, 4);

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(1));
        assertThat(Inventory.inventory.getQuantity(chai), is(2));
        assertThat(Inventory.inventory.getQuantity(latte), is(3));
        assertThat(Inventory.inventory.getQuantity(mocha), is(4));

        Inventory.inventory.removeItem(latte);

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(1));
        assertThat(Inventory.inventory.getQuantity(chai), is(2));
        assertThat(Inventory.inventory.getQuantity(latte), is(0));
        assertThat(Inventory.inventory.getQuantity(mocha), is(4));

        Inventory.inventory.removeItem(cappuccino);

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(0));
        assertThat(Inventory.inventory.getQuantity(chai), is(2));
        assertThat(Inventory.inventory.getQuantity(latte), is(0));
        assertThat(Inventory.inventory.getQuantity(mocha), is(4));
    }

    /**
     *
     * It tests for removing non-existing items from the inventory and
     * validating the items displayed on the menu
     * (refer {@link com.hackerrank.restaurant.menu.Menu#displayItems()})
     */
    @Test
    public void removeNonExistingItemAndValidateMenu() {
        Item cappuccino = new Coffee("Cappuccino", 3.58);
        Item chai = new Coffee("Chai", 3.71);
        Item latte = new Coffee("Latte", 3.78);
        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(cappuccino, 1);
        Inventory.inventory.addItem(chai, 2);
        Inventory.inventory.addItem(latte, 3);

        assertThat(Menu.menu.displayItems(), is("Cappuccino, Chai, Latte"));

        Inventory.inventory.removeItem(latte);

        assertThat(Menu.menu.displayItems(), is("Cappuccino, Chai"));

        String exceptionMessage = "";

        try {
            Inventory.inventory.removeItem(mocha);
        } catch (NoSuchItemException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Item 'Mocha' is not available."));

        assertThat(Menu.menu.displayItems(), is("Cappuccino, Chai"));

        Inventory.inventory.addItem(mocha, 4);

        assertThat(Menu.menu.displayItems(), is("Cappuccino, Chai, Mocha"));

        Inventory.inventory.removeItem(mocha);

        assertThat(Menu.menu.displayItems(), is("Cappuccino, Chai"));
    }

    /**
     *
     * It tests for removing non-existing items from the inventory and
     * validating the quantity of added items
     */
    @Test
    public void removeNonExistingItemAndValidateQuantity() {
        Item cappuccino = new Coffee("Cappuccino", 3.58);
        Item chai = new Coffee("Chai", 3.71);
        Item latte = new Coffee("Latte", 3.78);
        Item mocha = new Coffee("Mocha", 3.94);

        Inventory.inventory.addItem(cappuccino, 1);
        Inventory.inventory.addItem(chai, 2);
        Inventory.inventory.addItem(latte, 3);

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(1));
        assertThat(Inventory.inventory.getQuantity(chai), is(2));
        assertThat(Inventory.inventory.getQuantity(latte), is(3));
        assertThat(Inventory.inventory.getQuantity(mocha), is(0));

        Inventory.inventory.removeItem(latte);

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(1));
        assertThat(Inventory.inventory.getQuantity(chai), is(2));
        assertThat(Inventory.inventory.getQuantity(latte), is(0));
        assertThat(Inventory.inventory.getQuantity(mocha), is(0));

        String exceptionMessage = "";

        try {
            Inventory.inventory.removeItem(mocha);
        } catch (NoSuchItemException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Item 'Mocha' is not available."));

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(1));
        assertThat(Inventory.inventory.getQuantity(chai), is(2));
        assertThat(Inventory.inventory.getQuantity(latte), is(0));
        assertThat(Inventory.inventory.getQuantity(mocha), is(0));

        Inventory.inventory.addItem(mocha, 4);

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(1));
        assertThat(Inventory.inventory.getQuantity(chai), is(2));
        assertThat(Inventory.inventory.getQuantity(latte), is(0));
        assertThat(Inventory.inventory.getQuantity(mocha), is(4));

        Inventory.inventory.removeItem(mocha);

        assertThat(Inventory.inventory.getQuantity(cappuccino), is(1));
        assertThat(Inventory.inventory.getQuantity(chai), is(2));
        assertThat(Inventory.inventory.getQuantity(latte), is(0));
        assertThat(Inventory.inventory.getQuantity(mocha), is(0));
    }
}
