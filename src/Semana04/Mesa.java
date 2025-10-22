package Semana04;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Mesa {
    private List<Javali> javalist;
    private List<Cozinheiro> cozinheiros;
    private List<Gaules> vila;

    public Mesa() {
        this.javalist = new LinkedList<>();
        this.cozinheiros = new LinkedList<>();
        this.vila = new LinkedList<>();
    }

    public synchronized void addJavali(Javali javali) throws InterruptedException {
        while(javalist.size() > 10)
            wait();

        javalist.add(javali);
        notifyAll();
    }

    public synchronized Javali removeJavali() throws InterruptedException {
        while(javalist.isEmpty())
            wait();

        Javali j = javalist.removeFirst();
        notifyAll();

        return j;
    }

    public void addCozinheiro(Cozinheiro c) {
        this.cozinheiros.add(c);
    }

    public void addGaules(Gaules g) {
        this.vila.add(g);
    }

    public void jantar() {
        IntStream.range(0, 5).forEach(i -> { this.addCozinheiro(new Cozinheiro(this)); });
        IntStream.range(0, 10).forEach(i -> { this.addGaules(new Gaules(this)); });

        this.cozinheiros.forEach(Cozinheiro::start);
        this.vila.forEach(Gaules::start);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
        }

        this.cozinheiros.forEach(Cozinheiro::interrupt);
        this.vila.forEach(Gaules::interrupt);
        System.out.println("Fim do jantar");
    }

    public static void main(String[] args) {
        Mesa m = new Mesa();

        m.jantar();
    }
}
