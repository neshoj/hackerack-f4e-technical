package com.hackerrank.restaurant.order;

import com.hackerrank.restaurant.exceptions.NoSuchOrderException;
import com.hackerrank.restaurant.items.Item;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OrderPayment {
    /**
     * The customer id placing the order
     */
    private final long customerId;

    /**
     * The order id
     */
    private final long orderId;

    /**
     * @param customerId The customer id placing the order
     * @param orderId    The order id
     */
    public OrderPayment(long customerId, long orderId) {
        this.customerId = customerId;
        this.orderId = orderId;
    }

    /**
     * @return The total cost of the order
     * @throws NoSuchOrderException When the order does not exist
     */
    public double getPayableAmount() {

        List<Order> placedOrders = PlaceOrder.placeOrder.getOrders(this.customerId);

        if (placedOrders == null) {
            throw new NoSuchOrderException("Order (customer id: " + this.customerId + ", order id: " + this.orderId + ") does not exist.");
        }

        double payableAmount = 0.0;
        for (Order order : placedOrders) {
            if (order.getId() == this.orderId) {
                for (Map.Entry<Item, Integer> itemIntegerEntry : order.getItems().entrySet()) {
                    payableAmount += itemIntegerEntry.getKey().getCost() * itemIntegerEntry.getValue();
                }
            }
        }

        if (payableAmount == 0.0) {
            throw new NoSuchOrderException("Order (customer id: " + this.customerId + ", order id: " + this.orderId + ") does not exist.");
        }

        return payableAmount;
    }
}
