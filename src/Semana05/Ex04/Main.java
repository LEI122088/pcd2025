package Semana05.Ex04;

import Semana05.Ex01.Javali;
import Semana05.Ex01.Mesa;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Javali> m = new BlockingQueue<>(10);
        List<Gaules> gauleses = new LinkedList<>();
        List<Cozinheiro> cozinheiros = new LinkedList<>();

        IntStream.range(0, 5).forEach(_ -> gauleses.add(new Gaules(m)));
        IntStream.range(0, 5).forEach(_ -> cozinheiros.add(new Cozinheiro(m)));

        for(Cozinheiro c : cozinheiros)
            c.start();

        for(Gaules g : gauleses)
            g.start();

        Thread.sleep(10);

        for(Gaules g : gauleses)
            g.interrupt();

        for(Cozinheiro c : cozinheiros)
            c.interrupt();
    }
}
