package com.hackerrank.restaurant.tests;

import com.hackerrank.restaurant.inventory.Inventory;
import com.hackerrank.restaurant.exceptions.BadQuantityException;
import com.hackerrank.restaurant.exceptions.DuplicateItemEntryException;
import com.hackerrank.restaurant.exceptions.NoSuchItemException;
import com.hackerrank.restaurant.exceptions.NotEnoughItemException;
import com.hackerrank.restaurant.items.Item;
import com.hackerrank.restaurant.items.beverages.Cider;
import com.hackerrank.restaurant.items.beverages.Coffee;
import com.hackerrank.restaurant.items.beverages.Margarita;
import com.hackerrank.restaurant.items.beverages.Smoothie;
import com.hackerrank.restaurant.items.nonveg.NonVegPizza;
import com.hackerrank.restaurant.items.veg.VegBurger;
import com.hackerrank.restaurant.items.veg.VegPizza;
import com.hackerrank.restaurant.menu.Menu;
import com.hackerrank.restaurant.order.Order;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RestaurantOrderJUnitTest {
    private Item mulledCider;
    private Item spicyAppleCider;

    private Item latte;
    private Item mocha;

    private Item jalapenoMargarita;
    private Item strawberryMargarita;

    private Item razzyBlueSmoothie;
    private Item spaCucumberSmoothie;

    private Item kimchiBurger;
    private Item riceBurger;

    private Item buffaloBurger;
    private Item steakBurger;

    private Item farmHousePizza;
    private Item margheritaPizza;

    private Item chickenSausagePizza;
    private Item chickenTikkaPizza;

    /**
     *
     * Before running the tests:
     * <ul>
     *      <li>Remove all the items from the inventory</li>
     *      <li>Create items and add in the inventory</li>
     * </ul>
     */
    @Before
    public void setUp() {
        Inventory.inventory.removeAllItems();

        this.mulledCider = new Cider("Mulled Cider", 3.32);
        this.spicyAppleCider = new Cider("Spicy Apple Cider", 3.21);

        this.latte = new Coffee("Latte", 3.78);
        this.mocha = new Coffee("Mocha", 3.94);

        this.jalapenoMargarita = new Margarita("Jalapeno Margarita", 3.48);
        this.strawberryMargarita = new Margarita("Strawberry Margarita", 3.64);

        this.razzyBlueSmoothie = new Smoothie("Razzy Blue Smoothie", 4.24);
        this.spaCucumberSmoothie = new Smoothie("Spa Cucumber Smoothie", 4.24);

        this.kimchiBurger = new VegBurger("Kimchi Burger", 4.50);
        this.riceBurger = new VegBurger("Rice Burger", 4.50);

        this.buffaloBurger = new VegBurger("Buffalo Burger", 4.75);
        this.steakBurger = new VegBurger("Steak Burger", 4.75);

        this.farmHousePizza = new VegPizza("Farm House Pizza", 6.50);
        this.margheritaPizza = new VegPizza("Margherita Pizza", 6.50);

        this.chickenSausagePizza = new NonVegPizza("Chicken Sausage Pizza", 7.25);
        this.chickenTikkaPizza = new NonVegPizza("Chicken Tikka Pizza", 7.25);

        Inventory.inventory.addItem(this.mulledCider, 10);
        Inventory.inventory.addItem(this.spicyAppleCider, 10);
        Inventory.inventory.addItem(this.latte, 10);
        Inventory.inventory.addItem(this.mocha, 10);
        Inventory.inventory.addItem(this.jalapenoMargarita, 10);
        Inventory.inventory.addItem(this.strawberryMargarita, 10);
        Inventory.inventory.addItem(this.razzyBlueSmoothie, 10);
        Inventory.inventory.addItem(this.spaCucumberSmoothie, 10);
        Inventory.inventory.addItem(this.kimchiBurger, 10);
        Inventory.inventory.addItem(this.riceBurger, 10);
        Inventory.inventory.addItem(this.buffaloBurger, 10);
        Inventory.inventory.addItem(this.steakBurger, 10);
        Inventory.inventory.addItem(this.farmHousePizza, 10);
        Inventory.inventory.addItem(this.margheritaPizza, 10);
        Inventory.inventory.addItem(this.chickenSausagePizza, 10);
        Inventory.inventory.addItem(this.chickenTikkaPizza, 10);
    }

    /**
     *
     * It tests for:
     * <ul>
     *      <li>Adding items in the orders</li>
     *      <li>Validating the updated quantity of the added items in the
     * inventory</li>
     *      <li>Validating the items displayed on the menu
     * (refer {@link com.hackerrank.restaurant.menu.Menu#displayItems()})</li>
     * </ul>
     */
    @Test
    public void addItemAndValidateOrderAndValidateInventoryQuantityAndValidateMenu() {
        Order order = new Order(1);

        order.addItem(this.mulledCider, 2);
        order.addItem(this.spicyAppleCider, 2);
        order.addItem(this.latte, 3);

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mulled Cider 2 $3.32 $6.64",
                        "Spicy Apple Cider 2 $3.21 $6.42"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(10));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );
    }

    /**
     *
     * It tests for:
     * <ul>
     *      <li>Adding non-existing items in the orders</li>
     *      <li>Validating the updated quantity of the added items in the
     * inventory</li>
     *      <li>Validating the items displayed on the menu
     * (refer {@link com.hackerrank.restaurant.menu.Menu#displayItems()})</li>
     * </ul>
     */
    @Test
    public void addNonExistingItemAndValidateOrderAndValidateInventoryQuantityAndValidateMenu() {
        Order order = new Order(1);

        order.addItem(this.mulledCider, 2);
        order.addItem(this.spicyAppleCider, 2);
        order.addItem(this.latte, 3);
        order.addItem(this.mocha, 1);

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mocha 1 $3.94 $3.94",
                        "Mulled Cider 2 $3.32 $6.64",
                        "Spicy Apple Cider 2 $3.21 $6.42"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(9));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );

        Inventory.inventory.removeItem(this.mocha);

        String exceptionMessage = "";

        try {
            order.addItem(this.mocha, 2);
        } catch (NoSuchItemException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Item 'Mocha' is not available."));

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mocha 1 $3.94 $3.94",
                        "Mulled Cider 2 $3.32 $6.64",
                        "Spicy Apple Cider 2 $3.21 $6.42"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(0));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );
    }

    /**
     *
     * It tests for:
     * <ul>
     *      <li>Adding duplicate items in the orders</li>
     *      <li>Validating the updated quantity of the added items in the
     * inventory</li>
     *      <li>Validating the items displayed on the menu
     * (refer {@link com.hackerrank.restaurant.menu.Menu#displayItems()})</li>
     * </ul>
     */
    @Test
    public void addDuplicateItemAndValidateOrderAndValidateInventoryQuantityAndValidateMenu() {
        Order order = new Order(1);

        order.addItem(this.mulledCider, 2);
        order.addItem(this.spicyAppleCider, 2);
        order.addItem(this.latte, 3);
        order.addItem(this.mocha, 1);

        assertThat(
                order.printOrder(),
                        is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mocha 1 $3.94 $3.94",
                        "Mulled Cider 2 $3.32 $6.64",
                        "Spicy Apple Cider 2 $3.21 $6.42"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(9));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );

        String exceptionMessage = "";

        try {
            order.addItem(this.mocha, 2);
        } catch (DuplicateItemEntryException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Cannot add duplicate item 'Mocha'."));

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mocha 1 $3.94 $3.94",
                        "Mulled Cider 2 $3.32 $6.64",
                        "Spicy Apple Cider 2 $3.21 $6.42"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(9));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );
    }

    /**
     *
     * It tests for:
     * <ul>
     *      <li>Adding items in the orders with bad quantity, i.e.,
     *          <ul>
     *              <li>The value of the quantity is less than or equal to zero</li>
     *              <li>The updated value of the quantity is less than or equal to zero</li>
     *          </ul>
     *      </li>
     *      <li>Validating the updated quantity of the added items in the
     * inventory</li>
     *      <li>Validating the items displayed on the menu
     * (refer {@link com.hackerrank.restaurant.menu.Menu#displayItems()})</li>
     * </ul>
     */
    @Test
    public void addItemWithBadQuantityAndValidateOrderAndValidateInventoryQuantityAndValidateMenu() {
        Order order = new Order(1);

        order.addItem(this.mulledCider, 2);
        order.addItem(this.spicyAppleCider, 2);
        order.addItem(this.latte, 3);

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mulled Cider 2 $3.32 $6.64",
                        "Spicy Apple Cider 2 $3.21 $6.42"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(10));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );

        String exceptionMessage = "";

        try {
            order.addItem(this.mocha, 12);
        } catch (NotEnoughItemException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Not enough quantity for the item 'Mocha'."));

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mulled Cider 2 $3.32 $6.64",
                        "Spicy Apple Cider 2 $3.21 $6.42"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(10));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );

        try {
            order.addItem(this.mocha, 0);
        } catch (BadQuantityException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Expecting a value greater than zero but 0 found."));

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mulled Cider 2 $3.32 $6.64",
                        "Spicy Apple Cider 2 $3.21 $6.42"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(10));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );

        order.addItem(this.mocha, 5);

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mocha 5 $3.94 $19.70",
                        "Mulled Cider 2 $3.32 $6.64",
                        "Spicy Apple Cider 2 $3.21 $6.42"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(5));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );

        try {
            order.addItem(this.mocha, -1);
        } catch (BadQuantityException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Expecting a value greater than zero but -1 found."));

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mocha 5 $3.94 $19.70",
                        "Mulled Cider 2 $3.32 $6.64",
                        "Spicy Apple Cider 2 $3.21 $6.42"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(5));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );
    }

    /**
     *
     * It tests for:
     * <ul>
     *      <li>Incrementing and decrementing the quantity of the items in
     * the orders</li>
     *      <li>Validating the updated quantity of the added items in the
     * inventory</li>
     *      <li>Validating the items displayed on the menu
     * (refer {@link com.hackerrank.restaurant.menu.Menu#displayItems()})</li>
     * </ul>
     */
    @Test
    public void addItemAndIncrementDecrementQuantityAndValidateOrderAndValidateInventoryQuantityAndValidateMenu() {
        Order order = new Order(1);

        order.addItem(this.mulledCider, 2);
        order.addItem(this.spicyAppleCider, 2);
        order.addItem(this.latte, 3);
        order.addItem(this.mocha, 1);

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mocha 1 $3.94 $3.94",
                        "Mulled Cider 2 $3.32 $6.64",
                        "Spicy Apple Cider 2 $3.21 $6.42"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(9));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );

        order.incrementQuantity(this.mocha, 2);

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mocha 3 $3.94 $11.82",
                        "Mulled Cider 2 $3.32 $6.64",
                        "Spicy Apple Cider 2 $3.21 $6.42"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(7));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );

        order.decrementQuantity(this.spicyAppleCider, 1);

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mocha 3 $3.94 $11.82",
                        "Mulled Cider 2 $3.32 $6.64",
                        "Spicy Apple Cider 1 $3.21 $3.21"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(9));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(7));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );

        order.decrementQuantity(this.latte, 3);

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Mocha 3 $3.94 $11.82",
                        "Mulled Cider 2 $3.32 $6.64",
                        "Spicy Apple Cider 1 $3.21 $3.21"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(9));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(10));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(7));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );
    }

    /**
     *
     * It tests for:
     * <ul>
     *      <li>Incrementing and decrementing the quantity of the items in the
     * orders with bad quantity, i.e.,
     *          <ul>
     *              <li>The value of the quantity is less than or equal to zero</li>
     *              <li>The updated value of the quantity is less than or equal to zero</li>
     *          </ul>
     *      </li>
     *      <li>Validating the updated quantity of the added items in the
     * inventory</li>
     *      <li>Validating the items displayed on the menu
     * (refer {@link com.hackerrank.restaurant.menu.Menu#displayItems()})</li>
     * </ul>
     */
    @Test
    public void addItemAndBadIncrementBadDecrementQuantityAndValidateOrderAndValidateInventoryQuantityAndValidateMenu() {
        Order order = new Order(1);

        order.addItem(this.mulledCider, 2);
        order.addItem(this.spicyAppleCider, 2);
        order.addItem(this.latte, 3);
        order.addItem(this.mocha, 1);

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mocha 1 $3.94 $3.94",
                        "Mulled Cider 2 $3.32 $6.64",
                        "Spicy Apple Cider 2 $3.21 $6.42"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(9));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );

        String exceptionMessage = "";

        try {
            order.incrementQuantity(this.buffaloBurger, 2);
        } catch (NoSuchItemException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Item 'Buffalo Burger' is not available."));

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mocha 1 $3.94 $3.94",
                        "Mulled Cider 2 $3.32 $6.64",
                        "Spicy Apple Cider 2 $3.21 $6.42"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(9));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );

        try {
            order.decrementQuantity(this.kimchiBurger, 1);
        } catch (NoSuchItemException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Item 'Kimchi Burger' is not available."));

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mocha 1 $3.94 $3.94",
                        "Mulled Cider 2 $3.32 $6.64",
                        "Spicy Apple Cider 2 $3.21 $6.42"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(9));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );

        try {
            order.incrementQuantity(this.mocha, 10);
        } catch (NotEnoughItemException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Not enough quantity for the item 'Mocha'."));

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mocha 1 $3.94 $3.94",
                        "Mulled Cider 2 $3.32 $6.64",
                        "Spicy Apple Cider 2 $3.21 $6.42"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(9));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );

        try {
            order.decrementQuantity(this.latte, 4);
        } catch (NotEnoughItemException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Not enough quantity for the item 'Latte'."));

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mocha 1 $3.94 $3.94",
                        "Mulled Cider 2 $3.32 $6.64",
                        "Spicy Apple Cider 2 $3.21 $6.42"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(9));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );

        try {
            order.incrementQuantity(this.mocha, 0);
        } catch (BadQuantityException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Expecting a value greater than zero but 0 found."));

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mocha 1 $3.94 $3.94",
                        "Mulled Cider 2 $3.32 $6.64",
                        "Spicy Apple Cider 2 $3.21 $6.42"
                )));

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(9));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );

        try {
            order.decrementQuantity(this.mulledCider, -1);
        } catch (BadQuantityException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Expecting a value greater than zero but -1 found."));

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mocha 1 $3.94 $3.94",
                        "Mulled Cider 2 $3.32 $6.64",
                        "Spicy Apple Cider 2 $3.21 $6.42"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(9));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );
    }

    /**
     *
     * It tests for:
     * <ul>
     *      <li>Removing items from the orders</li>
     *      <li>Validating the updated quantity of the added items in the
     * inventory</li>
     *      <li>Validating the items displayed on the menu
     * (refer {@link com.hackerrank.restaurant.menu.Menu#displayItems()})</li>
     * </ul>
     */
    @Test
    public void removeItemAndValidateOrderAndValidateInventoryQuantityAndValidateMenu() {
        Order order = new Order(1);

        order.addItem(this.mulledCider, 2);
        order.addItem(this.spicyAppleCider, 2);
        order.addItem(this.latte, 3);
        order.addItem(this.mocha, 1);

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mocha 1 $3.94 $3.94",
                        "Mulled Cider 2 $3.32 $6.64",
                        "Spicy Apple Cider 2 $3.21 $6.42"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(9));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );

        order.removeItem(this.spicyAppleCider);

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mocha 1 $3.94 $3.94",
                        "Mulled Cider 2 $3.32 $6.64"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(10));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(9));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );

        order.removeItem(this.mocha);

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mulled Cider 2 $3.32 $6.64"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(10));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(10));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );
    }

    /**
     *
     * It tests for:
     * <ul>
     *      <li>Removing non-existing items from the orders</li>
     *      <li>Validating the updated quantity of the added items in the
     * inventory</li>
     *      <li>Validating the items displayed on the menu
     * (refer {@link com.hackerrank.restaurant.menu.Menu#displayItems()})</li>
     * </ul>
     */
    @Test
    public void removeNonExistingItemAndValidateOrderAndValidateInventoryQuantityAndValidateMenu() {
        Order order = new Order(1);

        order.addItem(this.mulledCider, 2);
        order.addItem(this.spicyAppleCider, 2);
        order.addItem(this.latte, 3);
        order.addItem(this.mocha, 1);

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mocha 1 $3.94 $3.94",
                        "Mulled Cider 2 $3.32 $6.64",
                        "Spicy Apple Cider 2 $3.21 $6.42"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(9));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );

        String exceptionMessage = "";

        try {
            order.removeItem(this.razzyBlueSmoothie);
        } catch (NoSuchItemException ex) {
            exceptionMessage = ex.getMessage();
        }

        assertThat(exceptionMessage, is("Item 'Razzy Blue Smoothie' is not available."));

        assertThat(
                order.printOrder(),
                is(String.join("\n",
                        "Latte 3 $3.78 $11.34",
                        "Mocha 1 $3.94 $3.94",
                        "Mulled Cider 2 $3.32 $6.64",
                        "Spicy Apple Cider 2 $3.21 $6.42"
                ))
        );

        assertThat(Inventory.inventory.getQuantity(this.mulledCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.spicyAppleCider), is(8));
        assertThat(Inventory.inventory.getQuantity(this.latte), is(7));
        assertThat(Inventory.inventory.getQuantity(this.mocha), is(9));
        assertThat(Inventory.inventory.getQuantity(this.jalapenoMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.strawberryMargarita), is(10));
        assertThat(Inventory.inventory.getQuantity(this.razzyBlueSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.spaCucumberSmoothie), is(10));
        assertThat(Inventory.inventory.getQuantity(this.kimchiBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.riceBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.buffaloBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.steakBurger), is(10));
        assertThat(Inventory.inventory.getQuantity(this.farmHousePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.margheritaPizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenSausagePizza), is(10));
        assertThat(Inventory.inventory.getQuantity(this.chickenTikkaPizza), is(10));

        assertThat(
                Menu.menu.displayItems(),
                is(String.join(", ",
                        "Buffalo Burger",
                        "Chicken Sausage Pizza",
                        "Chicken Tikka Pizza",
                        "Farm House Pizza",
                        "Jalapeno Margarita",
                        "Kimchi Burger",
                        "Latte",
                        "Margherita Pizza",
                        "Mocha",
                        "Mulled Cider",
                        "Razzy Blue Smoothie",
                        "Rice Burger",
                        "Spa Cucumber Smoothie",
                        "Spicy Apple Cider",
                        "Steak Burger",
                        "Strawberry Margarita"
                ))
        );
    }
}
