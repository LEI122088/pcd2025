package Semana03.Ex01;

public class Incrementador extends Thread {
    private final Contador contador;

    public Incrementador(Contador c) {
        this.contador = c;
    }

    public void run() {
        for(int i = 0; i < 1000; i++)
            this.contador.incrementa();

        System.out.println("Parcial: " + this.contador.getCont());
    }
}
