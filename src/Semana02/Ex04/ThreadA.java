package Semana02.Ex04;

import java.util.Random;

public class ThreadA extends Thread {
    private final Random random;
    private int count;

    public ThreadA() {
        this.random = new Random();
        this.count = 0;
    }

    @Override
    public void run() {
        while(!isInterrupted()) {
            this.count++;
            System.out.println(random.nextInt(1000, 10000));
        }
    }

    public void interrupt() {
        super.interrupt();

        System.out.println("Thread A produziu: " + this.count);
    }
}
