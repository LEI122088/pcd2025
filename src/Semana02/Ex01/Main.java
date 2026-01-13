package Semana02.Ex01;

public class Main {
    public static void main(String[] args) {
        NameThread t1 = new NameThread(1);
        NameThread t2 = new NameThread(2);

        try {
            t1.start();
            t2.start();

            Thread.sleep(4000);

            t1.interrupt();
            t2.interrupt();

            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(234);
        }
    }
}
