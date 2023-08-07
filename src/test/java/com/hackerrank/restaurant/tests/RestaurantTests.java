package com.hackerrank.restaurant.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
            com.hackerrank.restaurant.tests.RestaurantExceptionJUnitTest.class,
            com.hackerrank.restaurant.tests.RestaurantInventoryJUnitTest.class,
            com.hackerrank.restaurant.tests.RestaurantItemJUnitTest.class,
            com.hackerrank.restaurant.tests.RestaurantOrderJUnitTest.class,
            com.hackerrank.restaurant.tests.RestaurantOrderPaymentJUnitTest.class,
            com.hackerrank.restaurant.tests.RestaurantPlaceOrderJUnitTest.class
        }
)
public class RestaurantTests {
}
