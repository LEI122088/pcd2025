package src.Semana04;

public class Gaules extends Thread {
    private Mesa mesa;

    public Gaules(Mesa m) {
        this.mesa = m;
    }

    @Override
    public void run() {
        while(true)
            try {
                Javali j = this.mesa.removeJavali();
                System.out.println(getName() + " consumiu javali " + j);
            } catch (InterruptedException e) {
                System.out.println(getName() + " já está cheio.");
                break;
            }
    }
}
