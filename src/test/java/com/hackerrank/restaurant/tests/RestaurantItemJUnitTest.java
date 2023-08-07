package com.hackerrank.restaurant.tests;

import com.hackerrank.restaurant.items.Category;
import com.hackerrank.restaurant.items.Container;
import com.hackerrank.restaurant.items.Item;
import com.hackerrank.restaurant.items.beverages.Cider;
import com.hackerrank.restaurant.items.beverages.Coffee;
import com.hackerrank.restaurant.items.beverages.Margarita;
import com.hackerrank.restaurant.items.beverages.Smoothie;
import com.hackerrank.restaurant.items.nonveg.NonVegPizza;
import com.hackerrank.restaurant.items.veg.VegBurger;
import com.hackerrank.restaurant.items.veg.VegPizza;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class RestaurantItemJUnitTest {

    /**
     *
     * It tests for creating items and validating the items name
     * (refer {@link com.hackerrank.restaurant.items.Item})
     */
    @Test
    public void createItemAndValidateName() {
        Item mulledCider = new Cider("Mulled Cider", 3.32);
        Item spicyAppleCider = new Cider("Spicy Apple Cider", 3.21);

        Item latte = new Coffee("Latte", 3.78);
        Item mocha = new Coffee("Mocha", 3.94);

        Item jalapenoMargarita = new Margarita("Jalapeno Margarita", 3.48);
        Item strawberryMargarita = new Margarita("Strawberry Margarita", 3.64);

        Item razzyBlueSmoothie = new Smoothie("Razzy Blue Smoothie", 4.24);
        Item spaCucumberSmoothie = new Smoothie("Spa Cucumber Smoothie", 4.24);

        Item kimchiBurger = new VegBurger("Kimchi Burger", 4.50);
        Item riceBurger = new VegBurger("Rice Burger", 4.50);

        Item buffaloBurger = new VegBurger("Buffalo Burger", 4.75);
        Item steakBurger = new VegBurger("Steak Burger", 4.75);

        Item farmHousePizza = new VegPizza("Farm House Pizza", 6.50);
        Item margheritaPizza = new VegPizza("Margherita Pizza", 6.50);

        Item chickenSausagePizza = new NonVegPizza("Chicken Sausage Pizza", 7.25);
        Item chickenTikkaPizza = new NonVegPizza("Chicken Tikka Pizza", 7.25);

        assertThat(mulledCider.getName(), is("Mulled Cider"));
        assertThat(spicyAppleCider.getName(), is("Spicy Apple Cider"));
        assertThat(latte.getName(), is("Latte"));
        assertThat(mocha.getName(), is("Mocha"));
        assertThat(jalapenoMargarita.getName(), is("Jalapeno Margarita"));
        assertThat(strawberryMargarita.getName(), is("Strawberry Margarita"));
        assertThat(razzyBlueSmoothie.getName(), is("Razzy Blue Smoothie"));
        assertThat(spaCucumberSmoothie.getName(), is("Spa Cucumber Smoothie"));
        assertThat(kimchiBurger.getName(), is("Kimchi Burger"));
        assertThat(riceBurger.getName(), is("Rice Burger"));
        assertThat(buffaloBurger.getName(), is("Buffalo Burger"));
        assertThat(steakBurger.getName(), is("Steak Burger"));
        assertThat(farmHousePizza.getName(), is("Farm House Pizza"));
        assertThat(margheritaPizza.getName(), is("Margherita Pizza"));
        assertThat(chickenSausagePizza.getName(), is("Chicken Sausage Pizza"));
        assertThat(chickenTikkaPizza.getName(), is("Chicken Tikka Pizza"));
    }

    /**
     *
     * It tests for creating items and validating the items cost
     * (refer {@link com.hackerrank.restaurant.items.Item})
     */
    @Test
    public void createItemAndValidateCost() {
        Item mulledCider = new Cider("Mulled Cider", 3.32);
        Item spicyAppleCider = new Cider("Spicy Apple Cider", 3.21);

        Item latte = new Coffee("Latte", 3.78);
        Item mocha = new Coffee("Mocha", 3.94);

        Item jalapenoMargarita = new Margarita("Jalapeno Margarita", 3.48);
        Item strawberryMargarita = new Margarita("Strawberry Margarita", 3.64);

        Item razzyBlueSmoothie = new Smoothie("Razzy Blue Smoothie", 4.24);
        Item spaCucumberSmoothie = new Smoothie("Spa Cucumber Smoothie", 4.24);

        Item kimchiBurger = new VegBurger("Kimchi Burger", 4.50);
        Item riceBurger = new VegBurger("Rice Burger", 4.50);

        Item buffaloBurger = new VegBurger("Buffalo Burger", 4.75);
        Item steakBurger = new VegBurger("Steak Burger", 4.75);

        Item farmHousePizza = new VegPizza("Farm House Pizza", 6.50);
        Item margheritaPizza = new VegPizza("Margherita Pizza", 6.50);

        Item chickenSausagePizza = new NonVegPizza("Chicken Sausage Pizza", 7.25);
        Item chickenTikkaPizza = new NonVegPizza("Chicken Tikka Pizza", 7.25);

        assertThat(mulledCider.getCost(), is(3.32));
        assertThat(spicyAppleCider.getCost(), is(3.21));
        assertThat(latte.getCost(), is(3.78));
        assertThat(mocha.getCost(), is(3.94));
        assertThat(jalapenoMargarita.getCost(), is(3.48));
        assertThat(strawberryMargarita.getCost(), is(3.64));
        assertThat(razzyBlueSmoothie.getCost(), is(4.24));
        assertThat(spaCucumberSmoothie.getCost(), is(4.24));
        assertThat(kimchiBurger.getCost(), is(4.50));
        assertThat(riceBurger.getCost(), is(4.50));
        assertThat(buffaloBurger.getCost(), is(4.75));
        assertThat(steakBurger.getCost(), is(4.75));
        assertThat(farmHousePizza.getCost(), is(6.50));
        assertThat(margheritaPizza.getCost(), is(6.50));
        assertThat(chickenSausagePizza.getCost(), is(7.25));
        assertThat(chickenTikkaPizza.getCost(), is(7.25));
    }

    /**
     *
     * It tests for creating items, updating items costs and
     * validating the items updated costs
     * (refer {@link com.hackerrank.restaurant.items.Item})
     */
    @Test
    public void createItemAndUpdateCostAndValidateCost() {
        Item mulledCider = new Cider("Mulled Cider", 3.32);
        Item spicyAppleCider = new Cider("Spicy Apple Cider", 3.21);

        Item latte = new Coffee("Latte", 3.78);
        Item mocha = new Coffee("Mocha", 3.94);

        Item jalapenoMargarita = new Margarita("Jalapeno Margarita", 3.48);
        Item strawberryMargarita = new Margarita("Strawberry Margarita", 3.64);

        Item razzyBlueSmoothie = new Smoothie("Razzy Blue Smoothie", 4.24);
        Item spaCucumberSmoothie = new Smoothie("Spa Cucumber Smoothie", 4.24);

        Item kimchiBurger = new VegBurger("Kimchi Burger", 4.50);
        Item riceBurger = new VegBurger("Rice Burger", 4.50);

        Item buffaloBurger = new VegBurger("Buffalo Burger", 4.75);
        Item steakBurger = new VegBurger("Steak Burger", 4.75);

        Item farmHousePizza = new VegPizza("Farm House Pizza", 6.50);
        Item margheritaPizza = new VegPizza("Margherita Pizza", 6.50);

        Item chickenSausagePizza = new NonVegPizza("Chicken Sausage Pizza", 7.25);
        Item chickenTikkaPizza = new NonVegPizza("Chicken Tikka Pizza", 7.25);

        assertThat(mulledCider.getCost(), is(3.32));
        assertThat(spicyAppleCider.getCost(), is(3.21));
        assertThat(latte.getCost(), is(3.78));
        assertThat(mocha.getCost(), is(3.94));
        assertThat(jalapenoMargarita.getCost(), is(3.48));
        assertThat(strawberryMargarita.getCost(), is(3.64));
        assertThat(razzyBlueSmoothie.getCost(), is(4.24));
        assertThat(spaCucumberSmoothie.getCost(), is(4.24));
        assertThat(kimchiBurger.getCost(), is(4.50));
        assertThat(riceBurger.getCost(), is(4.50));
        assertThat(buffaloBurger.getCost(), is(4.75));
        assertThat(steakBurger.getCost(), is(4.75));
        assertThat(farmHousePizza.getCost(), is(6.50));
        assertThat(margheritaPizza.getCost(), is(6.50));
        assertThat(chickenSausagePizza.getCost(), is(7.25));
        assertThat(chickenTikkaPizza.getCost(), is(7.25));

        farmHousePizza.setCost(7.00);
        margheritaPizza.setCost(7.00);
        chickenSausagePizza.setCost(8.00);
        chickenTikkaPizza.setCost(8.00);

        assertThat(mulledCider.getCost(), is(3.32));
        assertThat(spicyAppleCider.getCost(), is(3.21));
        assertThat(latte.getCost(), is(3.78));
        assertThat(mocha.getCost(), is(3.94));
        assertThat(jalapenoMargarita.getCost(), is(3.48));
        assertThat(strawberryMargarita.getCost(), is(3.64));
        assertThat(razzyBlueSmoothie.getCost(), is(4.24));
        assertThat(spaCucumberSmoothie.getCost(), is(4.24));
        assertThat(kimchiBurger.getCost(), is(4.50));
        assertThat(riceBurger.getCost(), is(4.50));
        assertThat(buffaloBurger.getCost(), is(4.75));
        assertThat(steakBurger.getCost(), is(4.75));
        assertThat(farmHousePizza.getCost(), is(7.00));
        assertThat(margheritaPizza.getCost(), is(7.00));
        assertThat(chickenSausagePizza.getCost(), is(8.00));
        assertThat(chickenTikkaPizza.getCost(), is(8.00));
    }

    /**
     *
     * It tests for creating items and validating the items category
     * (refer {@link com.hackerrank.restaurant.items.Item})
     */
    @Test
    public void createItemAndValidateCategory() {
        Item mulledCider = new Cider("Mulled Cider", 3.32);
        Item spicyAppleCider = new Cider("Spicy Apple Cider", 3.21);

        Item latte = new Coffee("Latte", 3.78);
        Item mocha = new Coffee("Mocha", 3.94);

        Item jalapenoMargarita = new Margarita("Jalapeno Margarita", 3.48);
        Item strawberryMargarita = new Margarita("Strawberry Margarita", 3.64);

        Item razzyBlueSmoothie = new Smoothie("Razzy Blue Smoothie", 4.24);
        Item spaCucumberSmoothie = new Smoothie("Spa Cucumber Smoothie", 4.24);

        Item kimchiBurger = new VegBurger("Kimchi Burger", 4.50);
        Item riceBurger = new VegBurger("Rice Burger", 4.50);

        Item buffaloBurger = new VegBurger("Buffalo Burger", 4.75);
        Item steakBurger = new VegBurger("Steak Burger", 4.75);

        Item farmHousePizza = new VegPizza("Farm House Pizza", 6.50);
        Item margheritaPizza = new VegPizza("Margherita Pizza", 6.50);

        Item chickenSausagePizza = new NonVegPizza("Chicken Sausage Pizza", 7.25);
        Item chickenTikkaPizza = new NonVegPizza("Chicken Tikka Pizza", 7.25);

        assertThat(mulledCider.getCategory(), is(Category.HotBeverages));
        assertThat(spicyAppleCider.getCategory(), is(Category.HotBeverages));
        assertThat(latte.getCategory(), is(Category.HotBeverages));
        assertThat(mocha.getCategory(), is(Category.HotBeverages));
        assertThat(jalapenoMargarita.getCategory(), is(Category.ColdBeverages));
        assertThat(strawberryMargarita.getCategory(), is(Category.ColdBeverages));
        assertThat(razzyBlueSmoothie.getCategory(), is(Category.ColdBeverages));
        assertThat(spaCucumberSmoothie.getCategory(), is(Category.ColdBeverages));
        assertThat(kimchiBurger.getCategory(), is(Category.Snacks));
        assertThat(riceBurger.getCategory(), is(Category.Snacks));
        assertThat(buffaloBurger.getCategory(), is(Category.Snacks));
        assertThat(steakBurger.getCategory(), is(Category.Snacks));
        assertThat(farmHousePizza.getCategory(), is(Category.MainCourse));
        assertThat(margheritaPizza.getCategory(), is(Category.MainCourse));
        assertThat(chickenSausagePizza.getCategory(), is(Category.MainCourse));
        assertThat(chickenTikkaPizza.getCategory(), is(Category.MainCourse));
    }

    /**
     *
     * It tests for creating items and validating the items packaging material
     * (refer {@link com.hackerrank.restaurant.items.Item})
     */
    @Test
    public void createItemAndValidateContainer() {
        Item mulledCider = new Cider("Mulled Cider", 3.32);
        Item spicyAppleCider = new Cider("Spicy Apple Cider", 3.21);

        Item latte = new Coffee("Latte", 3.78);
        Item mocha = new Coffee("Mocha", 3.94);

        Item jalapenoMargarita = new Margarita("Jalapeno Margarita", 3.48);
        Item strawberryMargarita = new Margarita("Strawberry Margarita", 3.64);

        Item razzyBlueSmoothie = new Smoothie("Razzy Blue Smoothie", 4.24);
        Item spaCucumberSmoothie = new Smoothie("Spa Cucumber Smoothie", 4.24);

        Item kimchiBurger = new VegBurger("Kimchi Burger", 4.50);
        Item riceBurger = new VegBurger("Rice Burger", 4.50);

        Item buffaloBurger = new VegBurger("Buffalo Burger", 4.75);
        Item steakBurger = new VegBurger("Steak Burger", 4.75);

        Item farmHousePizza = new VegPizza("Farm House Pizza", 6.50);
        Item margheritaPizza = new VegPizza("Margherita Pizza", 6.50);

        Item chickenSausagePizza = new NonVegPizza("Chicken Sausage Pizza", 7.25);
        Item chickenTikkaPizza = new NonVegPizza("Chicken Tikka Pizza", 7.25);

        assertThat(mulledCider.getContainer(), is(Container.Cup));
        assertThat(spicyAppleCider.getContainer(), is(Container.Cup));
        assertThat(latte.getContainer(), is(Container.Cup));
        assertThat(mocha.getContainer(), is(Container.Cup));
        assertThat(jalapenoMargarita.getContainer(), is(Container.Glass));
        assertThat(strawberryMargarita.getContainer(), is(Container.Glass));
        assertThat(razzyBlueSmoothie.getContainer(), is(Container.Glass));
        assertThat(spaCucumberSmoothie.getContainer(), is(Container.Glass));
        assertThat(kimchiBurger.getContainer(), is(Container.Wrapper));
        assertThat(riceBurger.getContainer(), is(Container.Wrapper));
        assertThat(buffaloBurger.getContainer(), is(Container.Wrapper));
        assertThat(steakBurger.getContainer(), is(Container.Wrapper));
        assertThat(farmHousePizza.getContainer(), is(Container.Box));
        assertThat(margheritaPizza.getContainer(), is(Container.Box));
        assertThat(chickenSausagePizza.getContainer(), is(Container.Box));
        assertThat(chickenTikkaPizza.getContainer(), is(Container.Box));
    }
}
