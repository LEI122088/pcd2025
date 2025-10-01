package Semana03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int counter;
    private Lock lock;

    public Counter(int c) {
        this.counter = c;
        this.lock = new ReentrantLock();
    }

//    public synchronized void increment() { // implicit lock
    public void increment() { // explicit lock
        lock.lock();
        this.counter++;
        lock.unlock();
    }

    public int getCounter() {
        return this.counter;
    }
}
