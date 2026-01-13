package Semana02.Ex04;

import java.util.Random;

public class ThreadB extends Thread {
    private final Random random;
    private int count;

    public ThreadB() {
        this.random = new Random();
        this.count = 0;
    }

    public void run() {
        while(!isInterrupted()) {
            this.count++;
            System.out.println(this.random.nextInt(1, 10));

            try {
                sleep(500);
            } catch (InterruptedException e) {
                interrupt();
                break;
            }
        }
    }

    public void interrupt() {
        super.interrupt();
        System.out.println("ThreadB produziu: " + this.count);
    }
}
