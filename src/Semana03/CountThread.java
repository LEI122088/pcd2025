package Semana03;

public class CountThread extends Thread {
    private Counter counter;

    public CountThread(Counter c) {
        this.counter = c;
    }

    @Override
    public void run() {
        for(int i = 0; i < 1000; i++)
            this.counter.increment();
    }
}
