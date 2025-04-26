package org.example.currency;

public class Converter {

    public enum Currency {
        USD, // Доллар
        EUR, // Евро
        GBP, // Фунт стерлингов
        JPY  // Йена
    }

    private static final double USD_TO_EUR = 0.9;
    private static final double USD_TO_GBP = 0.8;
    private static final double USD_TO_JPY = 110.0;

    public double convert(double amount, Currency from, Currency to) {
        if (from == to) {
            return amount;
        }

        double amountInUSD;

        switch (from) {
            case USD -> amountInUSD = amount;
            case EUR -> amountInUSD = amount / USD_TO_EUR;
            case GBP -> amountInUSD = amount / USD_TO_GBP;
            case JPY -> amountInUSD = amount / USD_TO_JPY;
            default -> throw new IllegalArgumentException("Unknown currency: " + from);
        }

        // Перевод из долларов
        return switch (to) {
            case USD -> amountInUSD;
            case EUR -> amountInUSD * USD_TO_EUR;
            case GBP -> amountInUSD * USD_TO_GBP;
            case JPY -> amountInUSD * USD_TO_JPY;
        };
    }
}

