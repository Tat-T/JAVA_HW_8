package org.example.bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts = new HashMap<>();

    public void createAccount(String owner) {
        if (accounts.containsKey(owner)) {
            throw new IllegalArgumentException("Аккаунт уже существует!");
        }
        accounts.put(owner, new Account(owner));
    }

    public Account getAccount(String owner) {
        if (!accounts.containsKey(owner)) {
            throw new IllegalArgumentException("Аккаунт не найден!");
        }
        return accounts.get(owner);
    }
}

