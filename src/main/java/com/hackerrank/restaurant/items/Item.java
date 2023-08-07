package com.hackerrank.restaurant.items;

public interface Item {

    /**
     *
     * @return The item name
     */
    String getName();

    /**
     *
     * @return The item cost per unit
     */
    double getCost();

    /**
     *
     * @param cost The updated item cost
     */
    void setCost(double cost);

    /**
     *
     * @return The item category
     */
    Category getCategory();

    /**
     *
     * @return The item container
     */
    Container getContainer();
}
