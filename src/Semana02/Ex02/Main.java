package Semana02.Ex02;

public class Main {
    public static void main(String[] args) {
        Horse h1 = new Horse();
        Horse h2 = new Horse();
        Horse h3 = new Horse();

        h1.start();
        h2.start();
        h3.start();

        try {
            h1.join();
            h2.join();
            h3.join();
        } catch (InterruptedException e) {
            System.out.println(-1);
        }
    }
}
