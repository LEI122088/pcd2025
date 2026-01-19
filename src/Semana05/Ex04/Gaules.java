package Semana05.Ex04;

public class Gaules extends Thread {
    private BlockingQueue m;

    public Gaules(BlockingQueue m) {
        this.m = m;
    }

    public void run() {
        try {
            while(!isInterrupted()) {
                this.m.take();
                System.out.println("Nham nham, que delicia de javali");
            }
        } catch (InterruptedException e) {
            return;
        }
    }
}
