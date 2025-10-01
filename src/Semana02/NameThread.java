package Semana02;

public class NameThread extends Thread {
    private String name;

    public NameThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("Thread name: " + this.name + ".");

            try {
                sleep((int) ((Math.random() + 1) * 1000));
            } catch (InterruptedException e) {
                System.out.println("Thread " + this.name + " received order to interrupt.");

                return;
            }
        }
    }
}
