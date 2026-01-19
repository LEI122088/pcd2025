package Semana05.Ex04;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {
    private List<T> queue = new LinkedList<>();
    private Lock lock = new ReentrantLock();
    private Condition empty = lock.newCondition();
    private Condition full = lock.newCondition();
    private final int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public void add(T item) throws InterruptedException {
        lock.lock();

        try {
            while(this.queue.size() >= capacity)
                this.full.await();

            this.queue.add(item);
            this.empty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lock();

        T response;

        try {
            while(this.queue.isEmpty())
                this.empty.await();

            response = this.queue.removeFirst();
            this.full.signalAll();
        } finally {
            lock.unlock();
        }

        return response;
    }
}
