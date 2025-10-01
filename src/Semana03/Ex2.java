package Semana03;

import java.util.LinkedList;

public class Ex2 {
    private static LinkedList<QueueThread> threads = new LinkedList<>();
    private static IntQueue queue = new IntQueue();

    public static void main(String[] args) {
        createThreads();

        threads.forEach(Thread::start);

        waitForThreads();

        System.out.println("Tamanho da fila: " + queue.size());
    }

    private static void waitForThreads() {
        for(Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void createThreads() {
        for(int i = 0; i < 6; i++)
            threads.add(new QueueThread(queue));
    }
}
