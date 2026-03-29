package org.spring.lldPractice.tomato;

import org.spring.lldPractice.tomato.modal.Order;
import org.spring.lldPractice.tomato.modal.Resturant;
import org.spring.lldPractice.tomato.modal.User;
import org.spring.lldPractice.tomato.strategies.UpiPaymentStrategy;

public class Main {
    public static void main(String[] args) {
        // Simulating a happy flow
        // Create TomatoApp Object
        TomatoApp tomato = new TomatoApp();

        // Simulate a user coming in (Happy Flow)
        User user = new User(101, "Aditya", "Delhi");
        System.out.println("User: " + user.getName() + " is active.");

        // User searches for restaurants by location
        java.util.List<Resturant> restaurantList = tomato.searchRestaurants("Delhi");

        if (restaurantList.isEmpty()) {
            System.out.println("No restaurants found!");
            return;
        }

        System.out.println("Found Restaurants:");
        for (Resturant restaurant : restaurantList) {
            System.out.println(" - " + restaurant.getName());
        }

        // User selects a restaurant
        tomato.selectRestaurant(user, restaurantList.get(0));
        System.out.println("Selected restaurant: " + restaurantList.get(0).getName());

        // User adds items to the cart
        tomato.addToCart(user, "P1");
        tomato.addToCart(user, "P2");

        tomato.printUserCart(user);

        // User checkout the cart
        Order order = tomato.checkoutNow(user, "Delivery", new UpiPaymentStrategy("1234567890"));

        // User pays for the cart. If payment is successful, notification is sent.
        tomato.payForOrder(user, order);
    }
}
