package org.example.shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private final List<Product> catalog = new ArrayList<>();

    public void addProductToCatalog(Product product) {
        catalog.add(product);
    }

    public List<Product> getCatalog() {
        return new ArrayList<>(catalog);
    }

    public Order createOrder() {
        return new Order();
    }
}
