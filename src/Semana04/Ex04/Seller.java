package Semana04.Ex04;

import java.util.List;

public class Seller extends Thread {
    private int bought;
    private int id;
    private Distributor dealer;

    public Seller(Distributor d, int id) {
        this.id = id;
        this.bought = 0;
        this.dealer = d;
    }

    public void run() {
        while(!isInterrupted())
            try {
                List order = this.dealer.buy();
                this.bought += order.size();
                System.out.println("Seller ID: " + this.id + " bought " + order.size() + " items.");
            } catch(InterruptedException e) {
                return;
            }
    }
}
