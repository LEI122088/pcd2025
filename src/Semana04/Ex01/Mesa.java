package Semana04.Ex01;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private List<Javali> bandeja;
    private List<Cozinheiro> cozinheiros;
    private List<Gaules> gauleses;

    public Mesa() {
        this.bandeja = new ArrayList<Javali>();
        this.cozinheiros = new ArrayList<>();
        this.gauleses = new ArrayList<>();
    }

    public synchronized void recebeJavali(Javali j) throws InterruptedException {
        while(bandeja.size() >= 10) {
            wait();

            System.out.println("Tava sem espaço na bandeja, vocês estão muito devagar");
        }

        System.out.println("Entregando um novo javali");
        this.bandeja.add(j);
        notifyAll();
    }

    public synchronized void comeJavali() throws InterruptedException {
        while (bandeja.size() == 0) {
            wait();

            System.out.println("Tenho fome, onde é que andam estes javalis?");
        }


        System.out.println("Devorando um javali");
        this.bandeja.removeFirst();
        notifyAll();
    }

    public void addGaules(Gaules g) {
        this.gauleses.add(g);
    }

    public void addCozinheiro(Cozinheiro c) {
        this.cozinheiros.add(c);
    }

    public void start() {
        this.cozinheiros.forEach(Cozinheiro::start);
        this.gauleses.forEach(Gaules::start);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Algo deu errado na mesa de jantar");
        }

        for(Cozinheiro c : this.cozinheiros) {
            try {
                c.interrupt();
                c.join();
            } catch (InterruptedException e) {
                System.out.println("Cozinheiro encerrando o expediente...");
            }
        }

        for(Gaules g : this.gauleses) {
            try {
                g.interrupt();
                g.join();
            } catch (InterruptedException e) {
                System.out.println("Cozinheiro encerrando o expediente...");
            }
        }
    }
}
