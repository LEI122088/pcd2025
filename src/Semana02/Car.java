package Semana02;

import java.util.Observable;

import static java.lang.Thread.sleep;

public class Car extends Observable implements Runnable {
	private int id;
	private int limit;
	private int position = 0;

	public int getId() {
		return id;
	}

	public int getPosition() {
		return position;
	}

	public Car(int id, int limit) {
		super();
		this.id = id;
		this.limit = limit;
	}

	@Override
	public void run() {
		for(; position < limit; position++) {
			this.position++;

			setChanged();
			notifyObservers();

			try {
				sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
				System.out.println("Car " + id + " pulled over by the cops and out of race.");
				return;
			}
		}
	}

	private void idle() {

	}
}
