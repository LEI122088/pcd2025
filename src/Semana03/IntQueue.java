package Semana03;

import java.util.ArrayList;

public class IntQueue {
    private ArrayList<Integer> queue;
    private int lastIndex;

    public IntQueue() {
        this.queue = new ArrayList<>();
    }

    public synchronized int peek() throws IllegalStateException {
        if(this.queue.isEmpty())
            throw new IllegalStateException("A fila parece estar vazia");

        return this.queue.getFirst();
    }

    public synchronized int poll() throws IllegalStateException {
        if(this.queue.isEmpty())
            throw new IllegalStateException("A fila parece estar vazia");

        int r = this.queue.getFirst();
        this.queue.removeFirst();

        return r;
    }

    public synchronized void offer(int item) throws IllegalStateException {
        if(item == 0)
            throw new IllegalArgumentException("Argumento ilegal: item = " + item);

        this.queue.add(item);
    }

    public int size() {
        return this.queue.size();
    }
}
