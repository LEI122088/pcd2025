package Semana04.Ex01;

public class Cozinheiro extends Thread {
    private Mesa m;

    public Cozinheiro(Mesa m) {
        this.m = m;
    }

    public void run() {
        while(!isInterrupted()) {
            try {
                this.m.recebeJavali(new Javali());
            } catch (Exception e) {
                return;
            }
        }
    }

    public void interrupt() {
        super.interrupt();

        System.out.println("Interrompendo o cozinheiro");
    }
}
