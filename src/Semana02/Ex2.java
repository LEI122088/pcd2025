package Semana02;

import java.util.ArrayList;
import java.util.List;

public class Ex2 {
    private String winner;

    public Ex2() {}

    public synchronized void winner(String name) {
        if(this.winner == null) {
            this.winner = name;
            System.out.println("Horse " + name + " has won the race!");
        } else
            System.out.println("Horse " + name + " has finished the race, but didnt win it!");
    }

    public static void main(String[] args) {
        Ex2 sharedresource = new Ex2();

        List<HorseThread> horses = new ArrayList<>();

        horses.add(new HorseThread("Buttercup", sharedresource));
        horses.add(new HorseThread("Pé de pano", sharedresource));

        horses.forEach(horseThread -> horseThread.start());
    }
}
