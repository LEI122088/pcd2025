package Semana02;

import static java.lang.Thread.sleep;

public class Ex1 {
    public static void main(String[] args) {
        NameThread a = new NameThread("A");
        NameThread b = new NameThread("B");
        NameThread c = new NameThread("C");

        a.start();
        b.start();
        c.start();

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            return;
        }

        a.interrupt();
        b.interrupt();
        c.interrupt();

        try {
            a.join();
            b.join();
            c.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread terminated.");
        }

        System.out.println("All threads properly terminated.");
    }
}