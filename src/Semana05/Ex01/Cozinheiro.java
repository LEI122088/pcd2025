package Semana05.Ex01;

public class Cozinheiro extends Thread {
    private Mesa m;

    public Cozinheiro(Mesa m) {
        this.m = m;
    }

    public void run() {
        try {
            while(!isInterrupted()) {
                this.m.adicionaJavali(new Javali());
                System.out.println("Saindo um javali quentinho...");
            }
        } catch (InterruptedException e) {
            return;
        }
    }
}
