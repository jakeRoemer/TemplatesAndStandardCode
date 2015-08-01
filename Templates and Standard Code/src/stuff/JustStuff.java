package stuff;

import java.util.LinkedList;

import statistics.localRandom;

public class JustStuff {
	
	localRandom rand = new localRandom(System.currentTimeMillis());
	LinkedList<Integer> priorities = new LinkedList<Integer>();
	
	public static void main(String [] args) {
		Thread [] t = new Thread[10];
		JustStuff js = new JustStuff();
		for (int i = 0; i < t.length; i++) {
			t[i] = new Thread(js.new thread());
		}
		for (int i = 0; i < t.length; i++) {
			t[i].start();
		}
		for (int i = 0; i < t.length; i++) {
			try {
				t[i].join();
			} catch (InterruptedException e) { }
		}
	}
	
	public class thread implements Runnable {
		public void run() {
			int priority = rand.nextInt(10);
			while (priorities.contains(priority)) {
				priority = rand.nextInt(10);
			}
			priorities.add(priority);
			System.out.println(priority);
		}
	}
}
