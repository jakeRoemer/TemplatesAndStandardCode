package graphAlgorithms;

import java.util.Random;

public class Test {
	public static void main(String [] args) {
		// --- BFS test
		int numV = 10;
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
		topSort.DFS(G4);
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
		for(int i = 0; i < G.length; i++) {
			int edges = rand.nextInt(numV + 1);
			for(int j = 0; j < edges; j++) {
				G[i].addEdge(G[rand.nextInt(numV)]);
			}
		}
	}
}
