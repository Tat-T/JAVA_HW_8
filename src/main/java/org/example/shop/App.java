package org.example.shop;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop();

        // Добавим товары в каталог
        shop.addProductToCatalog(new Product("Ноутбук", 1000.0));
        shop.addProductToCatalog(new Product("Смартфон", 500.0));
        shop.addProductToCatalog(new Product("Наушники", 150.0));

        System.out.println("Добро пожаловать в наш магазин!");
        Order order = shop.createOrder();

        while (true) {
            System.out.println("\nКаталог товаров:");
            int index = 1;
            for (Product product : shop.getCatalog()) {
                System.out.printf("%d. %s - $%.2f\n", index++, product.getName(), product.getPrice());
            }
            System.out.println("0. Завершить заказ");

            System.out.print("Выберите товар по номеру: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }

            if (choice < 1 || choice > shop.getCatalog().size()) {
                System.out.println("Неверный выбор!");
            } else {
                Product selected = shop.getCatalog().get(choice - 1);
                order.addProduct(selected);
                System.out.println("Товар добавлен в заказ!");
            }
        }

        System.out.println("\nВаш заказ:");
        for (Product product : order.getProducts()) {
            System.out.printf("- %s ($%.2f)\n", product.getName(), product.getPrice());
        }
        System.out.printf("Итого: $%.2f\n", order.calculateTotal());
    }
}
