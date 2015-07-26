package graphAlgorithms;

import java.util.LinkedList;

public class TopologicalSort extends DepthFirstSearch {

	LinkedList<Node> topologicalSort = new LinkedList<Node>();
	
	@Override
	public void Visit(Node [] G, Node s, int time) {
		s.color = "GREY";
		s.setTime(time);
		for(int i = 0; i < s.numEdges; i++) {
			if(s.edges.get(i).color.equals("WHITE")) {
				Visit(G,s.edges.get(i),time);
			} else if (s.edges.get(i).color.equals("GREY")) {
				System.out.println("Cycle exists. Not a DAG.");
			}
		}
		s.color = "BLACK";
		s.setTime(++time);
		topologicalSort.add(0,s);
	}
}
