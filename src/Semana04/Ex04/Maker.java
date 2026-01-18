package Semana04.Ex04;

import java.util.Random;

public class Maker extends Thread {
    private Distributor dealer;
    private Random random = new Random();

    public Maker(Distributor d) {
        this.dealer = d;
    }

    public void run() {
        while(!isInterrupted()) {
            try {
                this.dealer.add(this.random.nextInt(0, 10));
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
