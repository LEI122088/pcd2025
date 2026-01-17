package Semana04.Ex01;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Mesa m = new Mesa();

        IntStream.range(0, 5).forEach(i -> { m.addCozinheiro(new Cozinheiro(m)); });
        IntStream.range(0, 5).forEach(i -> { m.addGaules(new Gaules(m)); });

        m.start();
    }
}
