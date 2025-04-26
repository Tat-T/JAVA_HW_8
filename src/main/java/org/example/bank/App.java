package org.example.bank;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n1. Создать счет\n2. Пополнить счет\n3. Снять деньги\n4. Проверить баланс\n5. Выход");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Введите имя владельца: ");
                        String owner = scanner.nextLine();
                        bank.createAccount(owner);
                        System.out.println("Счет создан!");
                    }
                    case 2 -> {
                        System.out.print("Введите имя владельца: ");
                        String owner = scanner.nextLine();
                        Account account = bank.getAccount(owner);
                        System.out.print("Введите сумму пополнения: ");
                        double amount = scanner.nextDouble();
                        account.deposit(amount);
                        System.out.println("Баланс пополнен!");
                    }
                    case 3 -> {
                        System.out.print("Введите имя владельца: ");
                        String owner = scanner.nextLine();
                        Account account = bank.getAccount(owner);
                        System.out.print("Введите сумму снятия: ");
                        double amount = scanner.nextDouble();
                        account.withdraw(amount);
                        System.out.println("Деньги сняты!");
                    }
                    case 4 -> {
                        System.out.print("Введите имя владельца: ");
                        String owner = scanner.nextLine();
                        Account account = bank.getAccount(owner);
                        System.out.printf("Баланс: %.2f\n", account.getBalance());
                    }
                    case 5 -> {
                        System.out.println("Выход...");
                        System.exit(0);
                    }
                    default -> System.out.println("Неверный выбор!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}