package Semana02.Ex04;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();

        a.start();
        b.start();

        try {
            Random r = new Random();
            Thread.sleep(r.nextInt(2000, 5000));
        } catch (InterruptedException e) {
            System.out.println(-1);
        }

        a.interrupt();
        b.interrupt();

        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
