package com.hackerrank.restaurant.order;

import com.hackerrank.restaurant.exceptions.NoSuchOrderException;

public class OrderPayment {
    /**
     *
     * The customer id placing the order
     */
    private final long customerId;

    /**
     *
     * The order id
     */
    private final long orderId;

    /**
     *
     * @param customerId The customer id placing the order
     * @param orderId The order id
     */
    public OrderPayment(long customerId, long orderId) {
        this.customerId = customerId;
        this.orderId = orderId;
    }

    /**
     *
     * @return The total cost of the order
     * @throws NoSuchOrderException When the order does not exist
     */
    public double getPayableAmount() {
        return 0.0;
    }
}
