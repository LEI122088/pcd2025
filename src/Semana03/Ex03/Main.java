package Semana03.Ex03;

public class Main {
    public static void main(String[] args) {
        Account acc = new Account();

        Customer c1 = new Customer(acc);
        Customer c2 = new Customer(acc);
        Customer c3 = new Customer(acc);
        Customer c4 = new Customer(acc);

        c1.start();
        c2.start();
        c3.start();
        c4.start();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        c1.interrupt();
        c2.interrupt();
        c3.interrupt();
        c4.interrupt();

        try {
            c1.join();
            c2.join();
            c3.join();
            c4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Total: " + acc.getBalance());
    }
}
