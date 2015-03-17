package graphAlgorithms;

public class GraphTranspose {
	
	public void transpose(Node [] G) {
		Node [] temp = new Node[G.length];
		for(int i = 0; i < G.length; i++) {
			Node n = new Node(i,G[i].distance,G[i].color);
			temp[i] = n;
			temp[i].discovered = G[i].discovered;
			temp[i].finished = G[i].finished;
		}
		//create transpose
		for(int i = 0; i < G.length; i++) {
			Node l = G[i];
			for(int j = 0; j < l.numEdges; j++){
				temp[l.edges.get(j).id].addEdge(l);
			}
		}
		//hard copy back into G
		for(int i = 0; i < temp.length; i++) {
			Node l = temp[i];
			G[i].clear();
			for(int j = 0; j < l.numEdges; j++) {
				G[i].addEdge(l.edges.get(j));
			}
		}
	}
}
