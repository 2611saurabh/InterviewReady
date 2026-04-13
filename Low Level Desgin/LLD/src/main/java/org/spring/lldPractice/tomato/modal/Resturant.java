package org.spring.lldPractice.tomato.modal;

import java.util.*;

public class Resturant {

    static int nextResutrantId = 0;
    int resturantId;
    String name;
    String location;
    List<MenuItem> menu = new ArrayList<>();

    public Resturant(String name, String location) {
        this.name = name;
        this.location = location;
        this.resturantId = ++nextResutrantId;
    }

    public static int getNextResutrantId() {
        return nextResutrantId;
    }

    public static void setNextResutrantId(int nextResutrantId) {
        Resturant.nextResutrantId = nextResutrantId;
    }

    public int getResturantId() {
        return resturantId;
    }

    public void setResturantId(int resturantId) {
        this.resturantId = resturantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }
}
