package Semana04.Ex04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Distributor d = new Distributor();
        Maker m = new Maker(d);
        List<Seller> sellers = new ArrayList<Seller>();

        IntStream.range(0, 5).forEach(i -> sellers.add(new Seller(d, i)));

        m.start();
        for(Seller s : sellers)
            s.start();

        Thread.sleep(100);

        m.interrupt();
        m.join();

        for(Seller s : sellers) {
            s.interrupt();
            s.join();
        }
    }
}
