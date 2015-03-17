package graphAlgorithms;

import java.util.LinkedList;

public class Node {
	
	int id;
	int distance;
	String color;
	LinkedList<Node> edges;
	int numEdges;
	int discovered;
	int finished;
	
	public Node(int id) {
		this.id = id;
		edges = new LinkedList<Node>();
		numEdges = 0;
		discovered = -1;
		finished = -1;
	}
	
	public Node(int id, int distance) {
		this.id = id;
		this.distance = distance;
		edges = new LinkedList<Node>();
		numEdges = 0;
		discovered = -1;
		finished = -1;
	}
	
	public Node(int id, int distance, String color) {
		this.id = id;
		this.distance = distance;
		this.color = color;
		edges = new LinkedList<Node>();
		numEdges = 0;
		discovered = -1;
		finished = -1;
	}
	
	public void addEdge(Node e) {
		edges.add(e);
		numEdges++;
	}
	
	public void removeEdge() {
		edges.remove();
		numEdges--;
	}
	
	public void removeEdge(int index) {
		edges.remove(index);
		numEdges--;
	}
	
	public void clear() {
		while(!edges.isEmpty()) {
			edges.remove();
			numEdges--;
		}
	}
	
	public void setTime(int time) {
		if(this.discovered == -1) {
			this.discovered = time;
		} else {
			this.finished = time;
		}
	}
}
