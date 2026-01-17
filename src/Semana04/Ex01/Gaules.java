package Semana04.Ex01;

public class Gaules extends Thread {
    private Mesa m;

    public Gaules(Mesa m) {
        this.m = m;
    }

    public void run() {
        while(!isInterrupted()) {
            try {
                this.m.comeJavali();
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void interrupt() {
        super.interrupt();

        System.out.println("Parando o Gaules");
    }
}
