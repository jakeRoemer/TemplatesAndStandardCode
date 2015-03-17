package minSpanTree;

public class MST {
	public int key;
	public MST parent;
	public int [] edges;
	
	public MST(int vertices){
		key = Integer.MAX_VALUE;
		parent = null;
		edges = new int[vertices];
	}
	
	public static void main(String [] args) {
		
	}
	
	public static void MST_Kruskal(MST [] graph) {
		
	}
	
	/*public static void MST_Prim(MST [] graph, MST root) {
		root.key = 0;
		LinkedList<MST> queue = new LinkedList<MST>();
		queue.add(root);
		Salesman vertex;
		while(!queue.isEmpty()) {
			vertex = extractMin(queue);
			for(int i = 0; i < vertex.edges.length; i++) {
				if(queue.contains(graph[i]) && vertex.edges[i] < vertex.key) {
					graph[i].parent = vertex;
					graph[i].key = vertex.edges[i];
				}
			}
		}
	}*/
}
