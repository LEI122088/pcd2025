package Semana02.Ex01;

import java.util.Random;
import java.util.random.RandomGenerator;

public class NameThread extends Thread {
    private int id;
    private Random random;

    public NameThread(int id) {
        this.id = id;
        this.random = new Random();
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println(this.id);
            try {
                sleep(1000L + random.nextInt(1000, 2000));
            } catch (InterruptedException e) {
                interrupt();
                break;
            }
        }
    }
}
