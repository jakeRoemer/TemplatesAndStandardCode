package graphAlgorithms;

import java.util.LinkedList;

public class Queue<T> {
	
	private final LinkedList<T> list;
	private int size;
	
	public Queue(){
		list = new LinkedList<T>();
		size = 0;
	}
	
	public Queue(T n){
		list = new LinkedList<T>();
		list.add(n);
		size++;
	}
	
	public void push(T n){
		list.add(n);
		size++;
	}
	
	public T pop(){
		size--;
		return list.remove(0);
	}
	
	public boolean isEmpty(){
		return size == 0 ? true : false;
	}
}
