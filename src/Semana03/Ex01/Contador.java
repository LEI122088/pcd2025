package Semana03.Ex01;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Contador {
    private AtomicInteger cont;
    private ReentrantLock lock;

    public Contador() {
        this.cont = new AtomicInteger(0);
        this.lock = new ReentrantLock();
    }

    public void incrementa() {
        this.cont.addAndGet(1);
    }

    public int getCont() {
        return cont.get();
    }
}
