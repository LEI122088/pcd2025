package Semana05.Ex04;

public class Cozinheiro extends Thread {
    private BlockingQueue m;

    public Cozinheiro(BlockingQueue m) {
        this.m = m;
    }

    public void run() {
        try {
            while(!isInterrupted()) {
                this.m.add(new Javali());
                System.out.println("Saindo um javali quentinho...");
            }
        } catch (InterruptedException e) {
            return;
        }
    }
}
