package bank;

import org.example.bank.Account;
import org.example.bank.Bank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    @Test
    public void testCreateAccount() {
        Bank bank = new Bank();
        bank.createAccount("Alice");
        assertNotNull(bank.getAccount("Alice"));
    }

    @Test
    public void testDeposit() {
        Bank bank = new Bank();
        bank.createAccount("Bob");
        Account account = bank.getAccount("Bob");
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        Bank bank = new Bank();
        bank.createAccount("Charlie");
        Account account = bank.getAccount("Charlie");
        account.deposit(200.0);
        account.withdraw(50.0);
        assertEquals(150.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        Bank bank = new Bank();
        bank.createAccount("Dave");
        Account account = bank.getAccount("Dave");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(10.0);
        });
        assertEquals("Недостаточно средств!", exception.getMessage());
    }
}

