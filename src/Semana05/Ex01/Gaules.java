package Semana05.Ex01;

public class Gaules extends Thread {
    private Mesa m;

    public Gaules(Mesa m) {
        this.m = m;
    }

    public void run() {
        System.out.println("Starting gaules...");
        try {
            while(!isInterrupted()) {
                this.m.pegaJavali();
                System.out.println("Nham nham, que delicia de javali");
            }
        } catch (InterruptedException e) {
            return;
        }
    }
}
