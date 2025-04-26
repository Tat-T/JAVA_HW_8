package org.example.currency;

import java.util.Scanner;

//import static currency.Converter.Currency;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Converter converter = new Converter();

        System.out.println("Конвертация валют:");
        System.out.println("1. Доллар (USD)\n2. Евро (EUR)\n3. Фунт стерлингов (GBP)\n4. Йена (JPY)");

        System.out.print("Выберите исходную валюту (1-4): ");
        int fromChoice = scanner.nextInt();
        System.out.print("Выберите целевую валюту (1-4): ");
        int toChoice = scanner.nextInt();
        System.out.print("Введите сумму: ");
        double amount = scanner.nextDouble();

        Converter.Currency from = choiceToCurrency(fromChoice);
        Converter.Currency to = choiceToCurrency(toChoice);

        double result = converter.convert(amount, from, to);

        System.out.printf("Результат: %.2f %s -> %.2f %s\n", amount, from, result, to);
    }

    private static Converter.Currency choiceToCurrency(int choice) {
        return switch (choice) {
            case 1 -> Converter.Currency.USD;
            case 2 -> Converter.Currency.EUR;
            case 3 -> Converter.Currency.GBP;
            case 4 -> Converter.Currency.JPY;
            default -> throw new IllegalArgumentException("Некорректный выбор валюты!");
        };
    }
}
