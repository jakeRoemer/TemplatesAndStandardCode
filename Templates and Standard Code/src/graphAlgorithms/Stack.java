package graphAlgorithms;

import java.util.LinkedList;

public class Stack<T> {
	
	private LinkedList<T> list;
	private int size;

	public Stack() {
		list = new LinkedList<T>();
		size = 0;
	}
	
	public Stack(T s) {
		list = new LinkedList<T> ();
		list.add(s);
		size = 1;
	}
	
	public void push(T s) {
		list.add(s);
		size++;
	}
	
	public T pop() {
		size--;
		return list.removeLast();
	}
	
	public boolean isEmpty() {
		return size == 0 ? true : false;
	}
}
