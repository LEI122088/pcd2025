package Semana04.Ex04;

import java.util.LinkedList;
import java.util.List;

public class Distributor {
    private List<Integer> storage;

    public Distributor() {
        this.storage = new LinkedList<>();
    }

    public synchronized void add(int value) throws InterruptedException {
        while(this.storage.size() >= 10)
            wait();

        notifyAll();
        this.storage.add(value);
    }

    public synchronized List buy() throws InterruptedException {
        while(this.storage.size() < 10) {
            wait();
        }

        List<Integer> response = this.storage;
        this.storage = new LinkedList<>();

        notifyAll();
        return response;
    }
}
