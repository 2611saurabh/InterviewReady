package org.spring.lldPractice.tomato.factories;

import org.spring.lldPractice.tomato.modal.*;
import org.spring.lldPractice.tomato.strategies.PaymentStrategy;

import java.util.List;

public interface OrderFactory {
    Order createOrder(User user, Cart cart, Resturant restaurant, List<MenuItem> menuItems,
                      PaymentStrategy paymentStrategy, double totalCost, String orderType);
}
