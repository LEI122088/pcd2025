package Semana02.Ex02;

import java.util.Random;

public class Horse extends Thread {
    private static int STEPS = 30;
    private final Random random;
    private int steps;
    private int id;

    public Horse() {
        this.steps = STEPS;
        this.random = new Random();
        this.id = this.random.nextInt();
    }

    public void run() {
        for(; this.steps >= 0; this.steps--) {
            try {
                System.out.println("Horse " + this.id + ": " + this.steps);
                sleep((long) this.random.nextLong(0, 100));
            } catch (InterruptedException e) {
                interrupt();
                break;
            }
        }
    }
}
