package lesson30._05_race;

import java.util.StringJoiner;

public class BankAccount {
    private long balance;
    private final Object lock = new Object();

    public BankAccount(long balance) {
        this.balance = balance;
    }

    public void withdraw(long amount) {
        synchronized (lock) {
            balance = balance - amount;
        }
    }

    public void deposit(long amount) {
        synchronized (lock) {
            balance = balance + amount;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(balance);
    }
}
