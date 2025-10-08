package src.Semana04;

public class Cozinheiro extends Thread {
    private Mesa mesa;

    public Cozinheiro(Mesa mesa) {
        this.mesa = mesa;
    }

    @Override
    public void run() {
        int i = 0;

        while(true)
            try {
                mesa.addJavali(new Javali("feito pelo cozinheiro " + this.getName() + " numero " + Integer.toString(i++)));
                System.out.println(getName() + " produziu mais um javali");
            } catch (InterruptedException e) {
                System.out.println(getName() + " cansou-se.");
                break;
            }
    }
}
