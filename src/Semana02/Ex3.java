package Semana02;

import javax.swing.JFrame;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Ex3 {

	public static void main(String[] args) {
		// GUI usage example... Change to suit exercise
		JFrame frame = new JFrame("Demo Track");
		Track track = new Track(3, 100);
		Car c0 = new Car(0, 100);
		Car c1 = new Car(1, 100);
		Car c2 = new Car(2, 100);
		c0.addObserver(track);
		c1.addObserver(track);
		c2.addObserver(track);

		frame.add(track);
		frame.setSize(500, 300);
		frame.setVisible(true);

		List<Thread> threads = new LinkedList<Thread>();
		threads.add(new Thread(c0));
		threads.add(new Thread(c1));
		threads.add(new Thread(c2));

		threads.forEach(Thread::start);
	}

}
