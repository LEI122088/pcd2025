package Semana05.Ex01;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Mesa {
    private List<Javali> bandeja;
    private ReentrantLock lock = new ReentrantLock();
    private Condition semJavali = lock.newCondition();
    private Condition javaliDemais = lock.newCondition();

    public Mesa() {
        this.bandeja = new LinkedList<>();
    }

    public void adicionaJavali(Javali j) throws InterruptedException {
        lock.lock();

        try {
            while(this.bandeja.size() >= 10) {
                javaliDemais.await();
            }

            this.bandeja.add(j);
            semJavali.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public Javali pegaJavali() throws InterruptedException {
        lock.lock();

        Javali j;

        try {
            while(this.bandeja.isEmpty())
                semJavali.await();

            j = this.bandeja.removeFirst();
            javaliDemais.signalAll();
        } finally {
            lock.unlock();
        }

        return j;
    }
}
