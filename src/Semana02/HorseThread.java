package Semana02;

public class HorseThread extends Thread {
    private String name;
    private int distanceToRun;
    private Ex2 ex2;

    public HorseThread (String name , Ex2 ex2) {
        this.name = name;
        this.distanceToRun = 30;
        this.ex2 = ex2;
    }

    @Override
    public void run() {
        while(this.distanceToRun > 0) {
            this.distanceToRun--;
//            if(this.distanceToRun < 5) System.out.println(this.distanceToRun);
            horseySleep();
        }

        ex2.winner(name);
    }

    private void horseySleep() {
        try {
            sleep((int) (Math.random() * 100));
        } catch (InterruptedException e) {
            System.out.println("Horse " + name + " forfeits the race.");
            return;
        }
    }
}
