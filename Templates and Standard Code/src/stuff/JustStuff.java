package stuff;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import statistics.localRandom;

public class JustStuff {
	
	localRandom rand = new localRandom(System.currentTimeMillis());
	LinkedList<Integer> priorities = new LinkedList<Integer>();
	
	public static void main(String [] args) {
		//testThreads();
		//testRand();
		//testInsertionSort();
		System.out.println("max: " + testFileRead());
	}
	
	public static int testFileRead() {
		int max = -1;
	    String line;
	    try {
	      //System.getProperty("user.home");
	      BufferedReader file = new BufferedReader(new FileReader(System.getProperty("user.home") + "/exp-output/rcd_PDR_MicroPriorityTests/none/adapt/gc_default/FTThreadScheduling-XvmsyncThrdSched0/var/1/output.txt"));
	      while ((line = file.readLine()) != null) {
	        if (line.matches("STATS:.*: numAcquiresForThread_.*")) {
	        	System.out.println(line);
	          if (max < Integer.parseInt(line.split(" = ")[1])) {
	            max = Integer.parseInt(line.split(" = ")[1]);
	          }
	        }
	      }
	      file.close();
	    } catch (FileNotFoundException e) { System.out.println("can not read max thread acquire count"); 
	    } catch (IOException e) { System.out.println("can not process line for max thread acquire count"); }
	    return max;
	}
	
	public static void testInsertionSort() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		Random rand = new Random(System.currentTimeMillis());
		int currentNum = 0;
		boolean added = false;
		for (int i = 0; i < 10; i++) {
			currentNum = rand.nextInt(100)+1;
			added = false;
			for (int j = list.size()-1; j >= 0; j--) {
				if (currentNum > list.get(j)) {
					list.add(j+1, currentNum);
					added = true;
					break;
				}
			}
			if (list.isEmpty()) {
				list.add(currentNum);
				added = true;
			}
			if (!added) {
				list.add(0, currentNum);
			}
		}
		System.out.println("contents of list:" + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(" " + list.get(i));
		}
		System.out.println();
		list.remove(0);
		list.add(101);
		System.out.println("contents of list:" + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(" " + list.get(i));
		}
		System.out.println();
	}
	
	public static void testRand() {
		Random rand = new Random(System.currentTimeMillis());
		int zeroCount = 0;
		for (int i = 0; i < 100; i++) {
			if (rand.nextInt(2) == 0) {
				zeroCount++;
				System.out.print(" rand: " + 0);
			} else {
				System.out.print(" rand: " + 1);
			}
		}
		System.out.println("\nzeroCount: " + zeroCount + " oneCount: " + (100-zeroCount));
	}
	
	public static void testThreads() {
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
