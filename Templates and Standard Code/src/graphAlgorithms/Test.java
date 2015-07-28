package graphAlgorithms;

import java.util.LinkedList;
import java.util.Random;

public class Test {
	public static void main(String [] args) {
		// --- BFS test
		int numV = 4;
		Node [] G = new Node[numV];
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		generateGraph(G, numV);
		Node start = G[0];
		bfs.BFS(G,start);
		// --- DFS recursive test
		Node [] G2 = new Node[numV];
		DepthFirstSearch dfs = new DepthFirstSearch();
		generateGraph(G2, numV);
		dfs.DFS(G2);
		// --- DFS non recursive test
		Node [] G3 = new Node[numV];
		generateGraph(G3, numV);
		dfs.nonRecursiveDFS(G3);
		// --- Topological Sort test
		Node [] G4 = new Node[numV];
		TopologicalSort topSort = new TopologicalSort();
		generateGraph(G4, numV);
		printGraph(G4);
		topSort.DFS(G4);
		printTopSort(topSort.topologicalSort);
		// --- Strongly Connected Components test
		Node [] G5 = new Node[numV];
		StronglyConnectedComponents scc = new StronglyConnectedComponents();
		generateGraph(G5, numV);
		scc.SCC(G5);
	}
	
	public static void generateGraph(Node [] G, int numV) {
		Random rand = new Random(System.currentTimeMillis());
		for(int i = 0; i < G.length; i++) {
			Node n = new Node(i);
			G[i] = n;
		}
		LinkedList<Integer> existingEdges = new LinkedList<Integer>();
		for(int i = 0; i < G.length; i++) {
			int edges = rand.nextInt(numV + 1);
			for(int j = 0; j < edges; j++) {
				int possibleEdge = rand.nextInt(numV);
				//No self-edges and only single edges
				if (possibleEdge != i && !existingEdges.contains(possibleEdge)) { 
					G[i].addEdge(G[possibleEdge]);
					existingEdges.add(possibleEdge);
				}
			}
			existingEdges.clear();
		}
	}
	
	public static void printGraph(Node [] G) {
		for (int i = 0; i < G.length; i++) {
			System.out.print(G[i].id + ": ");
			for (int j = 0; j < G[i].edges.size(); j++) {
				System.out.print(G[i].edges.get(j).id + " ");
			}
			System.out.print("| ");
		}
		System.out.println();
	}
	
	public static void printTopSort(LinkedList<Node> topologicalSort) {
		for (int i = 0; i < topologicalSort.size(); i++) {
			System.out.print(topologicalSort.get(i).id + " | ");
		}
		System.out.println();
	}
}
