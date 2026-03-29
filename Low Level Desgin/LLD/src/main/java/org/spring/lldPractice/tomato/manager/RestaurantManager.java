package org.spring.lldPractice.tomato.manager;

import org.spring.lldPractice.tomato.modal.*;
import java.util.ArrayList;
import java.util.List;

// Singleton
public class RestaurantManager {
    private List<Resturant> restaurants = new ArrayList<>();
    private static RestaurantManager instance = null;

    private RestaurantManager() {
        // private constructor
    }

    public static RestaurantManager getInstance() {
        if (instance == null) {
            instance = new RestaurantManager();
        }
        return instance;
    }

    public void addRestaurant(Resturant r) {
        restaurants.add(r);
    }

    public List<Resturant> searchByLocation(String loc) {
        List<Resturant> result = new ArrayList<>();
        loc = loc.toLowerCase();
        for (Resturant r : restaurants) {
            String rl = r.getLocation().toLowerCase();
            if (rl.equals(loc)) {
                result.add(r);
            }
        }
        return result;
    }
}