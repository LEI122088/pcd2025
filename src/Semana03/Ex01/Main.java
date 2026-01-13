package Semana03.Ex01;

public class Main {
    public static void main(String[] args) {
        Contador c = new Contador();

        Incrementador i1 = new Incrementador(c);
        Incrementador i2 = new Incrementador(c);
        Incrementador i3 = new Incrementador(c);
        Incrementador i4 = new Incrementador(c);

        i1.start();
        i2.start();
        i3.start();
        i4.start();

        try {
            i1.join();
            i2.join();
            i3.join();
            i4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Contagem: " + c.getCont());
    }
}
