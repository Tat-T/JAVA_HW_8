package org.example.bank;

public class Account {
    private final String owner;
    private double balance;

    public Account(String owner) {
        this.owner = owner;
        this.balance = 0.0;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма должна быть положительной!");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма должна быть положительной!");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Недостаточно средств!");
        }
        balance -= amount;
    }
}

