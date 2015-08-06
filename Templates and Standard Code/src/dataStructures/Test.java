package dataStructures;

import java.util.LinkedList;

public class Test {
	public static void main (String [] args) {
		testListAsArray();
	}
	
	//tests a list implementation using an underlying array against java library list
	public static void testListAsArray() {
		LinkedList<Integer> javaList = new LinkedList<Integer>();
		ListAsArray localList = new ListAsArray(10);
		System.out.println("javaList: " + javaList.contains(37));
		System.out.println("localList: " + localList.contains(37));
		System.out.println("javaList: " + javaList.indexOf(37));
		System.out.println("localList: " + localList.indexOf(37));
		for (int i = 0; i < 9; i++) {
			javaList.add(i);
			localList.add(i);
		}
		System.out.println("javaList: " + javaList.toString());
		System.out.println("localList: " + localList.toString());
		javaList.add(4,10);
		localList.add(4,10);
		System.out.println("javaList: " + javaList.toString());
		System.out.println("localList: " + localList.toString());
		javaList.add(5,20);
		localList.add(5,20);
		System.out.println("javaList: " + javaList.get(5));
		System.out.println("localList: " + localList.get(5));
		System.out.println("javaList: " + javaList.toString());
		System.out.println("localList: " + localList.toString());
		javaList.remove(7);
		localList.remove(7);
		System.out.println("javaList: " + javaList.get(5));
		System.out.println("localList: " + localList.get(5));
		System.out.println("javaList: " + javaList.toString());
		System.out.println("localList: " + localList.toString());
		javaList.add(2,100);
		localList.add(2,100);
		System.out.println("javaList: " + javaList.get(5));
		System.out.println("localList: " + localList.get(5));
		System.out.println("javaList: " + javaList.toString());
		System.out.println("localList: " + localList.toString());
		System.out.println("javaList: " + javaList.contains(37));
		System.out.println("localList: " + localList.contains(37));
		for (int i = 10-1; i >= 0; i--) {
			javaList.remove(i);
			localList.remove(i);
		}
		System.out.println("javaList: " + javaList.toString());
		System.out.println("localList: " + localList.toString());
		javaList.add(375);
		localList.add(375);
		javaList.add(895);
		localList.add(895);
		javaList.remove(895);
		localList.remove(895);
	}
}
