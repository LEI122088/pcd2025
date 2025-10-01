package Semana03;

public class QueueThread extends Thread {
    private IntQueue queue;

    public QueueThread(IntQueue q) {
        this.queue = q;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            double r = Math.random();

            if (r < 0.33)
                try {
                    this.queue.peek();
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            else if (r < 0.67)
                try {
                    this.queue.poll();
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            else
                try {
                    this.queue.offer((int) (Math.random() * 100));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
        }
    }
}
