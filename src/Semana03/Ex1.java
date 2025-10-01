package Semana03;

import java.util.LinkedList;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        Counter c = new Counter(0);

        List<CountThread> threads = new LinkedList<CountThread>();

        for (int i = 0; i < 4; i++)
            threads.add(new CountThread(c));

        threads.forEach(Thread::start);

        for (CountThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Algo de errado não está certo: " + e.getMessage());
            }
        }

        System.out.println("Contador:" + c.getCounter());
    }
}
