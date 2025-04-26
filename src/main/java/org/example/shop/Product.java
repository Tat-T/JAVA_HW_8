package org.example.shop;

public class Product {
    private final String name;
    private final double price;

    public Product(String name, double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть положительной!");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

