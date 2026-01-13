package Semana03.Ex03;

class Account {
    private long balance;

    public Account() {
        this.balance = 0;
    }

    public synchronized void deposit(int amount) // put money into the account
    {
        this.balance += amount;
    }

    public double getBalance() // get the current balance of the account
    {
        return this.balance;
    }
}