package Semana03.Ex03;

import java.util.Random;

public class Customer extends Thread {
    private Account acc;
    private int depositsTotal;
    private Random random;

    public Customer(Account acc) {
        this.acc = acc;
        this.depositsTotal = 0;
        this.random = new Random();
    }

    public void run() {
        while(!isInterrupted()) {
            int newDeposit = random.nextInt(0, 101);

            this.depositsTotal += newDeposit;
            acc.deposit(newDeposit);
        }
    }

    public void interrupt() {
        super.interrupt();

        System.out.println("Depositei: " + this.depositsTotal);
    }
}
