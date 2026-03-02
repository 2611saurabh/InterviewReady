package org.spring.SOLID.singleresponsibleprincipal.violated;

import java.util.ArrayList;
import java.util.List;

class Product {
    public String name;
    public double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.price;
        }
        return total;
    }

    public void printInvoice() {
        System.out.println("Shopping Cart Invoice:");
        for (Product p : products) {
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + calculateTotal());
    }

    public void saveToDatabase() {
        System.out.println("Saving shopping cart to database...");
    }
}

public class SRPViolated {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Laptop", 50000));
        cart.addProduct(new Product("Mouse", 2000));

        cart.printInvoice();
        cart.saveToDatabase();
    }
}
