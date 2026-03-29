package org.spring.lldPractice.tomato.factories;

import org.spring.lldPractice.tomato.modal.*;
import org.spring.lldPractice.tomato.strategies.PaymentStrategy;
import org.spring.lldPractice.tomato.utils.TimeUtils;

import java.util.List;

public class NowOrderFactory implements OrderFactory {
    @Override
    public Order createOrder(User user, Cart cart, Resturant resturant, List<MenuItem> menuItems,
                             PaymentStrategy paymentStrategy, double totalCost, String orderType) {
        Order order = null;

        if (orderType.equals("Delivery")) {
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getAddress());
            order = deliveryOrder;
        } else {
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setRestaurantAddress(resturant.getLocation());
            order = pickupOrder;
        }

        order.setUser(user);
        order.setResturant(resturant);
        order.setItems(menuItems);
        order.setPaymentStrategy(paymentStrategy);
        order.setScheduled(TimeUtils.getCurrentTime());
        order.setTotal(totalCost);
        return order;
    }
}