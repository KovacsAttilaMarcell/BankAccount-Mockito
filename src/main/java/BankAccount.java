public class BankAccount {

    private double balance = 0;

    public void deposit(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException("A befizetés összege csak pozitív, véges szám lehet.");
        }

        if (!Double.isFinite(balance + amount)) {
            throw new IllegalArgumentException("A befizetés túlcsordulást okozna.");
        }

        balance += amount;
    }

    public void withdraw(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException("A pénzfelvétel összege csak pozitív, véges szám lehet.");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Nincs elegendő fedezet a számlán.");
        }

        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
