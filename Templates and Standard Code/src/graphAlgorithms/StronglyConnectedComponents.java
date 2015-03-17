package graphAlgorithms;

import java.util.LinkedList;

public class StronglyConnectedComponents {

	public void SCC(Node [] G) {
		DepthFirstSearch dfs = new DepthFirstSearch();
		dfs.DFS(G);
		GraphTranspose gt = new GraphTranspose();
		gt.transpose(G);
		
	}
	
	// a DFS order by finishing times [oldest finishing time to youngest finishing time]
	public void orderedDFS(Node [] G){
		for(int i = 0; i < G.length; i++) {
			Node l = G[i];
			for(int j = 0; j < l.numEdges; j++) {
				l.edges.get(j).color = "WHITE";
			}
		}
		LinkedList<LinkedList<Node>> Forest = new LinkedList<LinkedList<Node>>();
		LinkedList<Node> Tree = new LinkedList<Node>();
		LinkedList<Integer> key = sortByFinishingTimes(G);
		sortGraphEdgesByFinishingTimes(G);
		for(int i = 0; i < key.size(); i++) {
			if(G[key.get(i)].color.equals("WHITE")) {
				orderedVisit(G, G[key.get(i)]);
			}
			Tree.clear();
			for(int j = 0; j < key.size(); j++) {
				if(G[j].color.equals("BLACK")) {
					Tree.add(G[j]);
				}
			}
			Forest.add(Tree);
		}
	}
	
	public void orderedVisit(Node [] G, Node s) {
		s.color = "GREY";
		for(int i = 0; i < s.numEdges; i++) {
			if(s.edges.get(i).color.equals("WHITE")) {
				orderedVisit(G,s.edges.get(i));
			}
		}
		s.color = "BLACK";
	}
	
	// an insertion sort
	public LinkedList<Integer> sortByFinishingTimes(Node [] G) {
		LinkedList<Integer> key = new LinkedList<Integer>();
		int j;
		for(int i = 0; i < G.length; i++) {
			j = 0;
			for(j = 0; j < key.size(); j++) {
				if(G[i].finished <= key.get(j)) {
					key.add(j,i);
					break;
				}
			}
			if(j == key.size()) {
				key.add(i);
			}
		}
		return key;
	}
	
	public void sortGraphEdgesByFinishingTimes(Node [] G) {
		for(int i = 0; i < G.length; i++) {
			sortEdgesByFinishingTimes(G[i].edges);
		}
	}
	
	public void sortEdgesByFinishingTimes(LinkedList<Node> edges) {
		LinkedList<Node> temp = new LinkedList<Node>();
		int j;
		for(int i = 0; i < edges.size(); i++) {
			j = 0;
			for(j = 0; j < temp.size(); j++) {
				if(edges.get(i).finished <= temp.get(j).finished) {
					temp.add(j,edges.get(i));
					break;
				}
			}
			if(j == temp.size()) {
				temp.add(edges.get(i));
			}
		}
		edges.clear();
		for(int i = 0; i < temp.size(); i++) {
			edges.add(temp.get(i));
		}
	}
}
