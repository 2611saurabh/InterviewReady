package org.spring.lldPractice.tomato.modal;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Resturant resturant;
    private List<MenuItem> items = new ArrayList<>();

    public Cart() {
        resturant = null;
    }

    public void addItem(MenuItem item) {
        if (resturant == null) {
            System.err.println("Cart: Set a restaurant before adding items.");
            return;
        }
        items.add(item);
    }

    public double getTotalCost() {
        double sum = 0;
        for (MenuItem it : items) {
            sum += it.getPrice();
        }
        return sum;
    }

    public boolean isEmpty() {
        return resturant == null || items.isEmpty();
    }

    public void clear() {
        items.clear();
        resturant = null;
    }

    public void setRestaurant(Resturant r) {
        resturant = r;
    }

    public Resturant getRestaurant() {
        return resturant;
    }

    public List<MenuItem> getItems() {
        return items;
    }
}
